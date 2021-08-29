package io.arkitik.ktx.radix.develop.usecase.adapter

import io.arkitik.ktx.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 07, **Sat Nov, 2020**
 * Project **ktx-radix** [https://arkitik.io](https://arkitik.io)
 */
data class ResponseAdapter<R>(
    val response: R,
) : UseCaseResponse