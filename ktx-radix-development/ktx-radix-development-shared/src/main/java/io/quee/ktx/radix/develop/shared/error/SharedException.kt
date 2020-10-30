package io.quee.ktx.radix.develop.shared.error

import java.util.*

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
open class SharedException(val errors: List<Error> = ArrayList()) : RuntimeException() {
    override val message: String
        get() = errors.toString()

    open class Builder internal constructor() {
        private val errors: MutableList<Error> = ArrayList()
        fun with(code: String, message: String): Builder {
            return with(Error(code, message))
        }

        fun with(error: Error): Builder {
            errors.add(error)
            return this
        }

        fun with(error: () -> Error): Builder {
            errors.add(error())
            return this
        }

        fun throwMeIfNotEmpty() {
            if (errors.isNotEmpty()) throw SharedException(errors)
        }

        @Throws(SharedException::class)
        fun throwMe() {
            throw SharedException(errors)
        }

        fun build(): SharedException {
            return SharedException(errors)
        }
    }

    companion object {
        fun builder(): Builder {
            return Builder()
        }
    }
}