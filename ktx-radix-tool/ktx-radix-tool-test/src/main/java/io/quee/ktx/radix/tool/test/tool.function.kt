package io.quee.ktx.radix.tool.test

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
val mapper = jacksonObjectMapper()

inline fun <reified T> Map<String, Any>.toObject(): T {
    return convert()
}

fun <T> T.toMap(): Map<String, Any> {
    return convert()
}

inline fun <T, reified R> T.convert(): R {
    val json = mapper.writeValueAsString(this)
    return mapper.readValue(json, R::class.java)
}
