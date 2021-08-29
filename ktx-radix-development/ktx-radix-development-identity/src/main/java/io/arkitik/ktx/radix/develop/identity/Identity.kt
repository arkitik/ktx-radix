package io.arkitik.ktx.radix.develop.identity

import java.io.Serializable
import java.time.LocalDateTime

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface Identity<ID : Serializable> : Serializable {
    val uuid: ID?
    val creationDate: LocalDateTime
}