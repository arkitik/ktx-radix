package io.quee.ktx.radix.tool.test.dto

import org.springframework.web.reactive.function.client.WebClientResponseException
import kotlin.reflect.KClass

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
enum class ResponseType(val responseException: KClass<out WebClientResponseException>?) {
    SUCCESS(null),
    BAD_REQUEST(WebClientResponseException.BadRequest::class),
    NOT_FOUND(WebClientResponseException.NotFound::class),
    UN_AUTHORIZED(WebClientResponseException.Unauthorized::class),
    NOT_ACCEPTABLE(WebClientResponseException.NotAcceptable::class)

}