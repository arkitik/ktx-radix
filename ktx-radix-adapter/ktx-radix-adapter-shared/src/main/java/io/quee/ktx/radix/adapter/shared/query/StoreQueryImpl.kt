package io.quee.ktx.radix.adapter.shared.query

import io.quee.ktx.radix.adapter.shared.paged
import io.quee.ktx.radix.adapter.shared.respository.MainRepository
import io.quee.ktx.radix.develop.identity.Identity
import io.quee.ktx.radix.develop.store.query.PageData
import io.quee.ktx.radix.develop.store.query.StoreQuery
import org.springframework.data.domain.PageRequest
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
open class StoreQueryImpl<ID : Serializable, I : Identity<ID>, E : I>(
        private val mainRepository: MainRepository<ID, E>
) : StoreQuery<ID, I> {
    override fun find(uuid: ID): I? = mainRepository.findByUuid(uuid)
    override fun exist(uuid: ID): Boolean = mainRepository.existsById(uuid)
    override fun allByUuids(uuids: List<ID>): Iterable<I> = mainRepository.findAllById(uuids)
    override fun all(): List<I> = mainRepository.findAll()
    override fun all(page: Int, size: Int): PageData<I> =
            this paged mainRepository.findAll(PageRequest.of(page, size))
}
