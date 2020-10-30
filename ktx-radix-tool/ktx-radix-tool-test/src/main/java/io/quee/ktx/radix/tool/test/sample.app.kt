package io.quee.ktx.radix.tool.test

import io.quee.ktx.radix.tool.test.dto.TestClassData
import io.quee.ktx.radix.tool.test.parser.JacksonDataParser
import io.quee.ktx.radix.tool.test.replacer.DefaultRegexReplacer

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
class SampleApp

fun main() {
    val dataParser = JacksonDataParser()
    val regexReplacer = DefaultRegexReplacer(dataParser)
    val testClassData = with(regexReplacer) {
        dataParser.run {
            val testClassData = SampleApp::class.java.classLoader.getResourceAsStream("sample.json")!!.parse(TestClassData::class)
            testClassData.write()
        }.replace()
    }
    println(testClassData)
}