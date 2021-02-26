package io.quee.ktx.radix.develop.operation

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 21, **Sun February, 2021**
 * Project *ktx-radix* [Quee.IO]
 */
interface Operation<RQ, RS> {
    fun RQ.operate(): RS
}

interface OperationRole<RQ, RS> {
    fun RQ.operateRole(): RS
}

interface Operator<RQ, RS> {
    fun RQ.operate(response: RS)
}

infix fun <RQ, RS> Operation<RQ, RS>.operationBuilder(
    builder: OperationBuilder<RQ, RS>.() -> Unit,
): Operation<RQ, RS> =
    OperationBuilder(this)
        .apply {
            builder()
        }

class OperationBuilder<RQ, RS>(
    private val mainOperation: Operation<RQ, RS>,
) : Operation<RQ, RS> {
    private val roles: MutableList<OperationRole<RQ, Unit>> = mutableListOf()
    private val afterOperators: MutableList<Operator<RQ, RS>> = mutableListOf()

    private fun RQ.before() =
        roles.forEach { it.run { operateRole() } }

    private fun RQ.process() =
        mainOperation.run { operate() }

    private fun RQ.after(response: RS) =
        afterOperators.forEach {
            it.run { operate(response) }
        }

    infix fun after(operator: Operator<RQ, RS>) {
        this.afterOperators.add(operator)
    }

    infix fun after(operator: RQ.(RS) -> Unit) {
        this.afterOperators.add(object : Operator<RQ, RS> {
            override fun RQ.operate(response: RS) {
                operator(response)
            }
        })
    }

    infix fun install(role: OperationRole<RQ, Unit>) {
        roles.add(role)
    }

    infix fun install(role: RQ.() -> Unit) {
        roles.add(object : OperationRole<RQ, Unit> {
            override fun RQ.operateRole() {
                role()
            }
        })
    }

    override fun RQ.operate(): RS {
        before()
        return process().apply {
            after(this)
        }
    }
}


