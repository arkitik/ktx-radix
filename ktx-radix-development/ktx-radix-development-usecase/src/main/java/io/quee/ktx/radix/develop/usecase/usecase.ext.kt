package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.factory.UseCaseFactory
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 29, **Thu Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */

infix fun <RQ : UseCaseRequest, RS : UseCaseResponse> FunctionalUseCase<RQ, RS>.process(request: RQ) =
    request.process()

infix fun <RQ : UseCaseRequest, RS : UseCaseResponse> FunctionalUseCase<RQ, RS>.process(requestProvider: () -> RQ) =
    this process requestProvider()

infix fun <RQ : UseCaseRequest> CommandUseCase<RQ>.execute(request: RQ) =
    request.execute()

infix fun <RQ : UseCaseRequest> CommandUseCase<RQ>.execute(requestProvider: () -> RQ) =
    this execute requestProvider()

infix fun <F : UseCaseFactory, RQ : UseCaseRequest, RS : UseCaseResponse> F.functional(functionalUseCase: F.() -> FunctionalUseCase<RQ, RS>) =
    functionalUseCase()

infix fun <F : UseCaseFactory, RQ : UseCaseRequest> F.command(commandUseCase: F.() -> CommandUseCase<RQ>) =
    commandUseCase()
