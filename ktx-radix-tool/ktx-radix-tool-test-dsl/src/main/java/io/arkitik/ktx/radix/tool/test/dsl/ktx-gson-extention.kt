package io.arkitik.ktx.radix.tool.test.dsl

import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
inline infix fun <reified T> Gson.parse(json: String): T {
    return fromJson(json, T::class.java)
}


inline infix fun <reified T> Gson.parse(json: JsonObject): T {
    return fromJson(json, T::class.java)
}