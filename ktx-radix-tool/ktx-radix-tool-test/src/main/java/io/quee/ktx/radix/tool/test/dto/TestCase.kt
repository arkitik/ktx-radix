package io.quee.ktx.radix.tool.test.dto

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
data class TestCase(
    val mapping: String,
    val responseType: ResponseType,
    val requestType: RequestType = RequestType.POST,
    val request: MutableMap<String, Any?>,
    val response: MutableMap<String, Any?>,
    val extraResponse: MutableMap<String, Any>? = null,
    val autoHeader: Boolean = true,
    val autoBankSignature: Boolean = true,
    val headers: List<KeyValue<String, String>> = ArrayList(),
    val signature: MutableMap<String, Any?>? = null,
    val specification: TestSpecification = TestSpecification(),
)