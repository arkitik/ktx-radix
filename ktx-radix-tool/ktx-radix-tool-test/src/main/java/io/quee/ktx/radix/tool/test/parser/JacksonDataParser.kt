package io.quee.ktx.radix.tool.test.parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.quee.ktx.radix.tool.test.function.DataParser
import java.io.InputStream
import kotlin.reflect.KClass

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
class JacksonDataParser(
        private val objectMapper: ObjectMapper = jacksonObjectMapper()
) : DataParser {
    override fun <T : Any> String.parse(clazz: KClass<T>): T = objectMapper.readValue(this, clazz.java)

    override fun <T : Any> InputStream.parse(clazz: KClass<T>): T = objectMapper.readValue(this, clazz.java)

    override fun <T : Any> T.write(): String = objectMapper.writeValueAsString(this)
}