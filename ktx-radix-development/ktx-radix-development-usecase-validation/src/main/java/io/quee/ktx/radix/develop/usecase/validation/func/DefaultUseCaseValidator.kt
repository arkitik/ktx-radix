package io.quee.ktx.radix.develop.usecase.validation.func

import io.quee.ktx.radix.develop.shared.error.Error
import io.quee.ktx.radix.develop.shared.ext.badRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator as JavaXValidator

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
open class DefaultUseCaseValidator internal constructor(
        private val validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator,
        private val errorMapper: ErrorMapper = DefaultErrorMapper()
) : UseCaseValidator {
    override fun <RQ : UseCaseRequest> RQ.validate() {
        validator.run {
            validate(this@validate)
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

    companion object {
        fun create(
                validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator,
                errorMapper: ErrorMapper = DefaultErrorMapper()
        ): UseCaseValidator {
            return DefaultUseCaseValidator(
                    validator, errorMapper
            )
        }
    }

    class DefaultErrorMapper : ErrorMapper {
        override fun <RQ : UseCaseRequest> ConstraintViolation<RQ>.mapToError(): Error {
            val nodes = propertyPath.toList()
            return when {
                nodes.isNotEmpty() -> {
                    Error(nodes[nodes.size - 1].name, message)
                }
                else -> Error(message, propertyPath.toString())
            }
        }
    }
}