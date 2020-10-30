package io.quee.ktx.radix.adapter.shared.respository

import io.quee.ktx.radix.develop.identity.Identity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
@NoRepositoryBean
interface MainRepository<ID : Serializable, I : Identity<ID>> : JpaRepository<I, ID> {
    fun findByUuid(id: ID): I?
}