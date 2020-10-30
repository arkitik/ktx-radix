package io.quee.ktx.radix.adapter.shared

import io.quee.ktx.radix.adapter.shared.query.StoreQueryImpl
import io.quee.ktx.radix.adapter.shared.respository.MainRepository
import io.quee.ktx.radix.develop.identity.Identity
import io.quee.ktx.radix.develop.store.Store
import io.quee.ktx.radix.develop.store.query.StoreQuery
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
abstract class StoreImpl<ID : Serializable, I : Identity<ID>, E : I>(
        private val mainRepository: MainRepository<ID, E>
) : Store<ID, I> {
    override fun ID.delete() = mainRepository.deleteById(this)
    override fun I.delete() = mainRepository.delete(map())
    abstract fun I.map(): E
    override fun I.save(): I = mainRepository.save(this.map())
    override fun List<I>.save(): Iterable<I> = mainRepository.saveAll(map {
        it.map()
    })

    override fun List<I>.deleteAll() {
        with(mainRepository) {
            deleteAll(map {
                it.map()
            })
        }
    }

    override fun List<ID>.deleteAllByIds() = forEach {
        mainRepository.deleteById(it)
    }

    override val storeQuery: StoreQuery<ID, I> = StoreQueryImpl(mainRepository)

}
