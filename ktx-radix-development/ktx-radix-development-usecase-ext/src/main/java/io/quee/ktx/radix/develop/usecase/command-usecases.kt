package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.actionable.ActionableCommandUseCase
import io.quee.ktx.radix.develop.usecase.factory.UseCaseFactory
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.validation.ValidationCommandUseCase

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 28, **Sat November, 2020**
 * Project *ktx-radix* [Quee.IO]
 */

infix fun <F : UseCaseFactory, RQ : UseCaseRequest> F.factoryCommandUseCase(builder: BuilderCommandUseCase<RQ>.(F) -> Unit): CommandUseCase<RQ> {
    val commandUseCase = BuilderCommandUseCase<RQ>()
    commandUseCase.builder(this)
    return commandUseCase
}

infix fun <F : UseCaseFactory, RQ : UseCaseRequest> F.factoryActionableCommandUseCase(builder: BuilderActionableCommandUseCase<RQ>.(F) -> Unit): CommandUseCase<RQ> {
    val commandUseCase = BuilderActionableCommandUseCase<RQ>()
    commandUseCase.builder(this)
    return commandUseCase
}

infix fun <F : UseCaseFactory, RQ : UseCaseRequest> F.factoryValidationCommandUseCase(builder: BuilderValidationCommandUseCase<RQ>.(F) -> Unit): CommandUseCase<RQ> {
    val commandUseCase = BuilderValidationCommandUseCase<RQ>()
    commandUseCase.builder(this)
    return commandUseCase
}


inline fun <RQ : UseCaseRequest> commandUseCase(builder: BuilderCommandUseCase<RQ>.() -> Unit): CommandUseCase<RQ> {
    val commandUseCase = BuilderCommandUseCase<RQ>()
    commandUseCase.builder()
    return commandUseCase
}

inline fun <RQ : UseCaseRequest> actionableCommandUseCase(builder: BuilderActionableCommandUseCase<RQ>.() -> Unit): CommandUseCase<RQ> {
    val commandUseCase = BuilderActionableCommandUseCase<RQ>()
    commandUseCase.builder()
    return commandUseCase
}

inline fun <RQ : UseCaseRequest> validationCommandUseCase(builder: BuilderValidationCommandUseCase<RQ>.() -> Unit): CommandUseCase<RQ> {
    val commandUseCase = BuilderValidationCommandUseCase<RQ>()
    commandUseCase.builder()
    return commandUseCase
}

class BuilderCommandUseCase<RQ : UseCaseRequest> : CommandUseCase<RQ> {
    private lateinit var command: RQ.() -> Unit

    override fun RQ.execute() = command()
    infix fun command(command: RQ.() -> Unit) {
        this.command = command
    }
}

class BuilderActionableCommandUseCase<RQ : UseCaseRequest> : ActionableCommandUseCase<RQ>() {
    private lateinit var command: RQ.() -> Unit
    private var beforeCommand: RQ.() -> Unit = {

    }
    private var afterCommand: RQ.() -> Unit = {

    }

    override fun RQ.doExecute() = command()
    override fun RQ.before() = beforeCommand()
    override fun RQ.after(response: Unit) = afterCommand()

    infix fun command(command: RQ.() -> Unit) {
        this.command = command
    }

    infix fun beforeCommand(beforeCommand: RQ.() -> Unit) {
        this.beforeCommand = beforeCommand
    }

    infix fun afterCommand(afterCommand: RQ.() -> Unit) {
        this.afterCommand = afterCommand
    }
}

class BuilderValidationCommandUseCase<RQ : UseCaseRequest> : ValidationCommandUseCase<RQ>() {
    private lateinit var command: RQ.() -> Unit
    private var afterCommand: RQ.() -> Unit = {

    }

    override fun RQ.doExecute() = command()
    override fun RQ.after(response: Unit) = afterCommand()

    infix fun command(command: RQ.() -> Unit) {
        this.command = command
    }

    infix fun afterCommand(afterCommand: RQ.() -> Unit) {
        this.afterCommand = afterCommand
    }
}