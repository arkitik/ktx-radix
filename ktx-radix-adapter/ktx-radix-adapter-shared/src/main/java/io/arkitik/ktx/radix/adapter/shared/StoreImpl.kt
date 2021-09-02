package io.arkitik.ktx.radix.adapter.shared

import io.arkitik.ktx.radix.adapter.shared.query.StoreQueryImpl
import io.arkitik.ktx.radix.adapter.shared.repository.KtxRepository
import io.arkitik.ktx.radix.develop.identity.Identity
import io.arkitik.ktx.radix.develop.store.Store
import io.arkitik.ktx.radix.develop.store.query.StoreQuery
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
abstract class StoreImpl<ID : Serializable, I : Identity<ID>, E : I>(
    private val repository: KtxRepository<ID, E>,
) : Store<ID, I> {
    override fun ID.delete() = repository.deleteById(this)
    override fun I.delete() = repository.delete(map())
    abstract fun I.map(): E
    override fun I.save(): I = repository.save(this.map())
    override fun List<I>.save(): Iterable<I> = repository.saveAll(map {
        it.map()
    })

    override fun List<I>.deleteAll() =
        with(repository) {
            deleteAll(map {
                it.map()
            })
        }

    override fun List<ID>.deleteAllByIds() =
        forEach {
            repository.deleteById(it)
        }

    override val storeQuery: StoreQuery<ID, I> = StoreQueryImpl(repository)
}
