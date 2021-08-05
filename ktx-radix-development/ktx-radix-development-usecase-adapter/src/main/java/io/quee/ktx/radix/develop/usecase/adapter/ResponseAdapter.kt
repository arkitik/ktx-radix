package io.quee.ktx.radix.develop.usecase.adapter

import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 07, **Sat Nov, 2020**
 * Project **ktx-radix** [https://quee.io](https://quee.io)
 */
data class ResponseAdapter<R>(
    val response: R,
) : UseCaseResponse