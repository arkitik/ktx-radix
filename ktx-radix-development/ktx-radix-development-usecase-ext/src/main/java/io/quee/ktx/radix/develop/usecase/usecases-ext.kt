package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.factory.UseCaseFactory
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse
import io.quee.ktx.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.quee.ktx.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 28, **Sat November, 2020**
 * Project *ktx-radix* [Quee.IO]
 */

typealias UseCaseRole<RQ, RS> = RQ.() -> RS
typealias UseCaseOperator<RQ, RS> = RQ.() -> RS

infix fun <F : UseCaseFactory, RQ : UseCaseRequest> F.commandUseCaseBuilder(
    builder: BuilderRoleValidationCommandUseCase<RQ>.(F) -> Unit
): CommandUseCase<RQ> =
    BuilderRoleValidationCommandUseCase<RQ>().apply {
        builder(this@commandUseCaseBuilder)
    }

inline fun <RQ : UseCaseRequest> commandUseCaseBuilder(
    builder: BuilderRoleValidationCommandUseCase<RQ>.() -> Unit
): CommandUseCase<RQ> =
    BuilderRoleValidationCommandUseCase<RQ>().apply {
        builder()
    }

infix fun <F : UseCaseFactory, RQ : UseCaseRequest, RS : UseCaseResponse> F.functionalUseCaseBuilder(
    builder: BuilderValidationFunctionalUseCase<RQ, RS>.(F) -> Unit
): FunctionalUseCase<RQ, RS> =
    BuilderValidationFunctionalUseCase<RQ, RS>().apply {
        builder(this@functionalUseCaseBuilder)
    }

inline fun <RQ : UseCaseRequest, RS : UseCaseResponse> functionalUseCaseBuilder(
    builder: BuilderValidationFunctionalUseCase<RQ, RS>.() -> Unit
): FunctionalUseCase<RQ, RS> =
    BuilderValidationFunctionalUseCase<RQ, RS>().apply {
        builder()
    }

class BuilderRoleValidationCommandUseCase<RQ : UseCaseRequest> : ValidationCommandUseCase<RQ>() {
    private lateinit var command: UseCaseOperator<RQ, Unit>
    private var afterOperators: MutableList<UseCaseOperator<RQ, Unit>> = mutableListOf()
    private var roles: MutableList<UseCaseRole<RQ, Unit>> = mutableListOf()
    override fun RQ.doBefore() =
        roles.forEach {
            it()
        }

    override fun RQ.doExecute() = command()
    override fun RQ.after(response: Unit) = afterOperators.forEach { it() }

    infix fun command(command: UseCaseOperator<RQ, Unit>) {
        this.command = command
    }

    infix fun afterCommand(operator: UseCaseOperator<RQ, Unit>) {
        this.afterOperators.add(operator)
    }

    infix fun install(role: UseCaseRole<RQ, Unit>) {
        roles.add(role)
    }
}

class BuilderValidationFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> :
    ValidationFunctionalUseCase<RQ, RS>() {
    private lateinit var function: RQ.() -> RS
    private var roles: MutableList<UseCaseRole<RQ, Unit>> = mutableListOf()
    private var afterOperators: MutableList<UseCaseOperator<RQ, RS>> = mutableListOf()

    override fun RQ.doBefore() = roles.forEach { it() }

    override fun RQ.doProcess() = function()

    override fun RQ.after(response: RS) = afterOperators.forEach { it() }

    infix fun function(function: RQ.() -> RS) {
        this.function = function
    }

    infix fun afterFunction(operator: UseCaseOperator<RQ, RS>) {
        this.afterOperators.add(operator)
    }

    infix fun install(role: UseCaseRole<RQ, Unit>) {
        roles.add(role)
    }
}