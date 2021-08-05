package io.quee.ktx.radix.develop.store.updater

import io.quee.ktx.radix.develop.identity.Identity
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
interface StoreIdentityUpdater<ID : Serializable, I : Identity<ID>> {
    fun update(): I
}