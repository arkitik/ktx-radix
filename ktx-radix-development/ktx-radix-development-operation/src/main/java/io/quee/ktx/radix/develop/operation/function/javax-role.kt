package io.quee.ktx.radix.develop.operation.function

import io.quee.ktx.radix.develop.operation.OperationRole
import io.quee.ktx.radix.develop.shared.error.Error
import io.quee.ktx.radix.develop.shared.ext.badRequest
import javax.validation.ConstraintViolation
import javax.validation.Validation

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
@Deprecated(
    message = "To be removed in v2.0.0, replaced by module ktx-radix-development-operation-ext",
    replaceWith = ReplaceWith(
        expression = "DefaultJavaXValidator",
        "io.quee.ktx.radix.develop.operation.ext.DefaultJavaXValidator"
    ),
)
object DefaultJavaXValidator : JavaXValidator()

@Deprecated(
    message = "To be removed in v2.0.0, replaced by module ktx-radix-development-operation-ext",
    replaceWith = ReplaceWith(
        expression = "JavaXValidator",
        "io.quee.ktx.radix.develop.operation.ext.JavaXValidator"
    ),
)
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

@Deprecated(
    message = "To be removed in v2.0.0, replaced by module ktx-radix-development-operation-ext",
    replaceWith = ReplaceWith(
        expression = "DefaultErrorMapper",
        "io.quee.ktx.radix.develop.operation.ext.DefaultErrorMapper"
    ),
)
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

@Deprecated(
    message = "To be removed in v2.0.0, replaced by module ktx-radix-development-operation-ext",
    replaceWith = ReplaceWith(
        expression = "ErrorMapper",
        "io.quee.ktx.radix.develop.operation.ext.ErrorMapper"
    ),
)
interface ErrorMapper {
    fun <RQ> ConstraintViolation<RQ>.mapToError(): Error
}