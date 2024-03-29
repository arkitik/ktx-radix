package io.arkitik.ktx.radix.develop.store

import io.arkitik.ktx.radix.develop.identity.Identity
import io.arkitik.ktx.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.ktx.radix.develop.store.query.StoreQuery
import io.arkitik.ktx.radix.develop.store.updater.StoreIdentityUpdater
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface Store<ID : Serializable, I : Identity<ID>> {
    fun I.save(): I
    fun List<I>.save(): Iterable<I>
    fun ID.delete()
    fun I.delete()
    fun List<ID>.deleteAllByIds()
    fun List<I>.deleteAll()
    val storeQuery: StoreQuery<ID, I>
    fun identityCreator(): StoreIdentityCreator<ID, I>
    fun I.identityUpdater(): StoreIdentityUpdater<ID, I>
}