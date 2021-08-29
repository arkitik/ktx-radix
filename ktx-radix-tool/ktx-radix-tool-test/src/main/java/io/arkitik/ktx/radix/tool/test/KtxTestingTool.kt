package io.arkitik.ktx.radix.tool.test

import io.arkitik.ktx.radix.tool.test.dto.TestCase
import io.arkitik.ktx.radix.tool.test.dto.TestClassData
import io.arkitik.ktx.radix.tool.test.function.DataParser
import io.arkitik.ktx.radix.tool.test.http.HttpTestProcessor
import io.arkitik.ktx.radix.tool.test.parser.JacksonDataParser
import io.arkitik.ktx.radix.tool.test.processor.Processor
import io.arkitik.ktx.radix.tool.test.regex.RegexReplacer
import io.arkitik.ktx.radix.tool.test.replacer.DefaultRegexReplacer
import org.junit.jupiter.api.DynamicTest
import java.io.InputStream
import java.nio.file.InvalidPathException
import kotlin.reflect.KClass

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
class KtxTestingTool(
    private val parser: DataParser,
    private val regexReplacer: RegexReplacer,
    private val processor: Processor,
) {
    fun <RS : Any> run(
        resourceFilePath: String,
        classLoader: ClassLoader = javaClass.classLoader,
        clazz: KClass<RS>,
        successCall: (TestCase, RS?) -> Unit,
        failCall: (TestCase, Throwable) -> Unit,
    ): List<DynamicTest> {
        val jsonInputStream = classLoader.getResourceAsStream(resourceFilePath)
        return if (jsonInputStream != null)
            run(jsonInputStream, clazz, successCall, failCall)
        else {
            throw InvalidPathException(resourceFilePath, "Could not open resources, file not found")
        }
    }

    fun <RS : Any> run(
        jsonInputStream: InputStream,
        clazz: KClass<RS>,
        successCall: (TestCase, RS?) -> Unit,
        failCall: (TestCase, Throwable) -> Unit,
    ): List<DynamicTest> {
        val testClassData = parser.run {
            jsonInputStream.parse(TestClassData::class)
        }
        return run(testClassData, clazz, successCall, failCall)
    }

    fun <RS : Any> run(
        testClassData: TestClassData,
        clazz: KClass<RS>,
        successCall: (TestCase, RS?) -> Unit,
        failCall: (TestCase, Throwable) -> Unit,
    ): List<DynamicTest> {
        return regexReplacer.run {
            parser.run {
                testClassData.write().replace()
                    .scenarios
                    .map { scenario ->
                        DynamicTest.dynamicTest(scenario.name) {
                            scenario.cases.forEach {
                                processor.process(it, clazz, successCall, failCall)
                            }
                        }
                    }
            }
        }
    }

    companion object {
        fun create(
            parser: DataParser,
            rootUrl: String,
            testCaseSignatureCreator: TestCase.() -> String,
        ) = create(
            parser,
            HttpTestProcessor(
                rootUrl,
                parser,
                testCaseSignatureCreator
            )
        )

        fun create(
            processor: Processor,
        ) = create(
            processor,
            JacksonDataParser()
        )

        fun create(
            processor: Processor,
            parser: JacksonDataParser,
        ) = create(
            parser,
            processor
        )

        fun create(
            parser: DataParser,
            processor: Processor,
        ) = create(
            parser,
            DefaultRegexReplacer(parser),
            processor
        )

        fun create(
            parser: DataParser,
            regexReplacer: RegexReplacer,
            processor: Processor,
        ) = KtxTestingTool(
            parser,
            regexReplacer,
            processor
        )
    }
}