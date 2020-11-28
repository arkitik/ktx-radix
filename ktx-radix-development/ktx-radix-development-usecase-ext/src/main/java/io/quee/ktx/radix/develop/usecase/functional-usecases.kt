package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.actionable.ActionableFunctionalUseCase
import io.quee.ktx.radix.develop.usecase.factory.UseCaseFactory
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse
import io.quee.ktx.radix.develop.usecase.validation.ValidationFunctionalUseCase

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 28, **Sat November, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
inline fun <F : UseCaseFactory, RQ : UseCaseRequest, RS : UseCaseResponse> F.factoryFunctionalUseCase(builder: BuilderFunctionalUseCase<RQ, RS>.(F) -> Unit): FunctionalUseCase<RQ, RS> {
    val functionalUseCase = BuilderFunctionalUseCase<RQ, RS>()
    functionalUseCase.builder(this)
    return functionalUseCase
}

inline fun <F : UseCaseFactory, RQ : UseCaseRequest, RS : UseCaseResponse> F.factoryActionableFunctionalUseCase(builder: BuilderActionableFunctionalUseCase<RQ, RS>.(F) -> Unit): FunctionalUseCase<RQ, RS> {
    val functionalUseCase = BuilderActionableFunctionalUseCase<RQ, RS>()
    functionalUseCase.builder(this)
    return functionalUseCase
}

inline fun <F : UseCaseFactory, RQ : UseCaseRequest, RS : UseCaseResponse> F.factoryValidationFunctionalUseCase(builder: BuilderValidationFunctionalUseCase<RQ, RS>.(F) -> Unit): FunctionalUseCase<RQ, RS> {
    val functionalUseCase = BuilderValidationFunctionalUseCase<RQ, RS>()
    functionalUseCase.builder(this)
    return functionalUseCase
}

inline fun <RQ : UseCaseRequest, RS : UseCaseResponse> functionalUseCase(builder: BuilderFunctionalUseCase<RQ, RS>.() -> Unit): FunctionalUseCase<RQ, RS> {
    val functionalUseCase = BuilderFunctionalUseCase<RQ, RS>()
    functionalUseCase.builder()
    return functionalUseCase
}

inline fun <RQ : UseCaseRequest, RS : UseCaseResponse> actionableFunctionalUseCase(builder: BuilderActionableFunctionalUseCase<RQ, RS>.() -> Unit): FunctionalUseCase<RQ, RS> {
    val functionalUseCase = BuilderActionableFunctionalUseCase<RQ, RS>()
    functionalUseCase.builder()
    return functionalUseCase
}

inline fun <RQ : UseCaseRequest, RS : UseCaseResponse> validationFunctionalUseCase(builder: BuilderValidationFunctionalUseCase<RQ, RS>.() -> Unit): FunctionalUseCase<RQ, RS> {
    val functionalUseCase = BuilderValidationFunctionalUseCase<RQ, RS>()
    functionalUseCase.builder()
    return functionalUseCase
}

class BuilderFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> : FunctionalUseCase<RQ, RS> {
    private lateinit var function: RQ.() -> RS
    override fun RQ.process() = function()

    infix fun function(function: RQ.() -> RS) {
        this.function = function
    }
}

class BuilderActionableFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> : ActionableFunctionalUseCase<RQ, RS>() {
    private lateinit var function: RQ.() -> RS
    private var beforeFunction: RQ.() -> Unit = {

    }
    private var afterFunction: RQ.(RS) -> Unit = {

    }

    override fun RQ.doProcess() = function()
    override fun RQ.before() = beforeFunction()
    override fun RQ.after(response: RS) = afterFunction(response)

    infix fun function(function: RQ.() -> RS) {
        this.function = function
    }

    infix fun beforeFunctional(beforeFunctional: RQ.() -> Unit) {
        this.beforeFunction = beforeFunctional
    }

    infix fun afterFunctional(afterFunctional: RQ.(RS) -> Unit) {
        this.afterFunction = afterFunctional
    }
}

class BuilderValidationFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> : ValidationFunctionalUseCase<RQ, RS>() {
    private lateinit var function: RQ.() -> RS

    private var afterFunction: RQ.(RS) -> Unit = {

    }

    override fun RQ.doProcess() = function()

    override fun RQ.after(response: RS) = afterFunction(response)

    infix fun function(function: RQ.() -> RS) {
        this.function = function
    }

    infix fun afterFunction(afterFunction: RQ.(RS) -> Unit) {
        this.afterFunction = afterFunction
    }
}