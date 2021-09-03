package io.arkitik.ktx.radix.adapter.shared.repository

import io.arkitik.ktx.radix.develop.identity.Identity
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
@NoRepositoryBean
interface KtxRepository<ID : Serializable, I : Identity<ID>> : PagingAndSortingRepository<I, ID> {
    fun findByUuid(id: ID): I?
}
