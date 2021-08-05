package io.quee.ktx.radix.develop.usecase.adapter

import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 07, **Sat Nov, 2020**
 * Project **ktx-radix** [https://quee.io](https://quee.io)
 */
data class RequestAdapter<R>(
    val request: R,
) : UseCaseRequest