package io.quee.ktx.radix.usecase.reactive.command

import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import reactor.core.publisher.Mono

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */
interface ReactiveMonoCommandUseCase<RQ : UseCaseRequest> {
    fun Mono<RQ>.execute()
}