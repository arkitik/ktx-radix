package io.arkitik.ktx.radix.adapter.shared

import io.arkitik.ktx.radix.develop.identity.Identity
import io.arkitik.ktx.radix.develop.store.query.PageData
import io.arkitik.ktx.radix.develop.store.query.StoreQuery
import org.springframework.data.domain.Page
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */

infix fun <ID : Serializable, I : Identity<ID>, E : I> StoreQuery<ID, I>.paged(data: Page<E>): PageData<I> =
    PageData(data.content, data.numberOfElements, data.totalElements, data.totalPages, data.number, data.size)
