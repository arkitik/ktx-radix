package io.quee.ktx.radix.develop.usecase

import io.quee.ktx.radix.develop.usecase.factory.UseCaseFactory
import io.quee.ktx.radix.develop.usecase.model.UseCaseRequest
import io.quee.ktx.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 27, **Fri November, 2020**
 * Project *ktx-radix* [Quee.IO]
 */

data class Sample(val ss: String) : UseCaseRequest
data class SampleA(val ss: String) : UseCaseResponse

val ssssA = functionalUseCase<Sample, SampleA> {
    function {
        println("Functional : ${this.ss}")
        SampleA(this.ss)
    }
}

interface SAAA : UseCaseFactory {
    val commandA: CommandUseCase<Sample>
    val commandD: CommandUseCase<Sample>
    val commandC: FunctionalUseCase<Sample, SampleA>
}

class SampleFactory(private val sample: String) : SAAA {
    override val commandD: CommandUseCase<Sample> = factoryCommandUseCase {
        command {
            println("it.sample = ${it.sample}")
        }
    }
    override val commandA: CommandUseCase<Sample> = commandUseCase {
        command {
            println("Command : $sample")
        }
        command {
            println("Command : $sample")
        }
    }
    override val commandC = ssssA

    val xcf = factoryValidationFunctionalUseCase<SampleFactory, Sample, SampleA> {
        function {
            SampleA(it.sample)
        }
    }

}

fun main() {
    SampleFactory("ssss") command {
        commandD
    } execute Sample("Help Me Nigger")

    val sampleA = SampleFactory("ssss") functional {
        commandC
    } process Sample("Help Me Nigger!!!!")

    println("Result Func: $sampleA")
}