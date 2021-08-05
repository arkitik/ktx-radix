package io.quee.ktx.radix.develop.store.creator

import io.quee.ktx.radix.develop.identity.Identity
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
interface StoreIdentityCreator<ID : Serializable, I : Identity<ID>> {
    fun ID.uuid(): StoreIdentityCreator<ID, I>
    fun create(): I
}