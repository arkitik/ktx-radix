package io.arkitik.ktx.radix.develop.usecase.actionable

import io.arkitik.ktx.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface Actionable<RQ : UseCaseRequest, RS> {
    fun RQ.before()
    fun RQ.after(response: RS)
}