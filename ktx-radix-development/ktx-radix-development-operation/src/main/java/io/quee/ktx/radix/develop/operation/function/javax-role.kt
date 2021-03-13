package io.quee.ktx.radix.develop.operation.function

import io.quee.ktx.radix.develop.operation.OperationRole
import io.quee.ktx.radix.develop.shared.error.Error
import io.quee.ktx.radix.develop.shared.ext.badRequest
import javax.validation.ConstraintViolation
import javax.validation.Validation

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
object DefaultJavaXValidator : JavaXValidator()

open class JavaXValidator internal constructor(
    private val validator: javax.validation.Validator = Validation.buildDefaultValidatorFactory().validator,
    private val errorMapper: ErrorMapper = DefaultErrorMapper,
) : OperationRole<Any, Unit> {
    override fun Any.operateRole() {
        validator.run {
            validate(this@operateRole)
        }.takeIf {
            it.isNotEmpty()
        }?.map {
            errorMapper.run {
                it.mapToError()
            }
        }?.badRequest()?.run {
            throw this
        }
    }
}

object DefaultErrorMapper : ErrorMapper {
    override fun <RQ> ConstraintViolation<RQ>.mapToError(): Error {
        val nodes = propertyPath.toList()
        return when {
            nodes.isNotEmpty() -> {
                Error(nodes[nodes.size - 1].name, message)
            }
            else -> Error(message, propertyPath.toString())
        }
    }
}

interface ErrorMapper {
    fun <RQ> ConstraintViolation<RQ>.mapToError(): Error
}