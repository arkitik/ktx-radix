package io.quee.ktx.radix.tool.json.dsl

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */

/**
 * Creates a [JsonArray], calls the provided function on it, and returns it
 */
fun ktxJsonObject(init: KtxJsonObjectBuilder.() -> Unit): JsonObject {
    val builder = KtxJsonObjectBuilder()
    builder.init()
    return builder.build()
}

/**
 * Returns a [JsonArray] with the elements provided.
 *
 * Items provided must either be [Boolean], [Char], [String], [Number], or [JsonElement]
 */
fun ktxJsonArray(vararg item: Any?): JsonArray {
    return item.toList().toJsonArray()
}

/**
 * Converts a [List] to a [JsonArray]
 */
fun List<*>.toJsonArray(): JsonArray {
    val jsonArray = JsonArray()
    this.forEach {
        when (it) {
            is Boolean -> jsonArray.add(it)
            is Char -> jsonArray.add(it)
            is String -> jsonArray.add(it)
            is Number -> jsonArray.add(it)
            is JsonElement -> jsonArray.add(it)
            null -> jsonArray.add(JsonNull.INSTANCE)
            else -> jsonArray.add(it.toString())
        }
    }
    return jsonArray
}

/**
 * Alternative syntax for [List].[toJsonArray]. Converts the [List] into a [JsonArray].
 */
fun ktxJsonArray(list: List<Any>) = list.toJsonArray()

/**
 * Converts a [HashMap] to a [JsonObject]
 */
fun <X, Y> HashMap<X, Y>.toJsonObject(): JsonObject {
    return ktxJsonObject {
        forEach { (t, u) -> t.toString() to u }
    }
}