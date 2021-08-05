package io.quee.ktx.radix.develop.operation.ext

import io.quee.ktx.radix.develop.operation.Operation
import io.quee.ktx.radix.develop.operation.OperationRole
import io.quee.ktx.radix.develop.operation.Operator

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 02, **Tue March, 2021**
 * Project *ktx-radix* [https://quee.io]
 */
infix fun <RQ, RS> Operation<RQ, RS>.runOperation(request: RQ) = request.operate()

infix fun <RQ, RS> OperationRole<RQ, RS>.operateRole(request: RQ) = request.operateRole()

fun <RQ, RS> Operator<RQ, RS>.runOperator(request: RQ, response: RS) = request.operate(response)

class FunctionOperation<RQ, RS>(
    private val function: RQ.() -> RS,
) : Operation<RQ, RS> {
    override fun RQ.operate() = function()
}

class MapperOperation<RQ, RS>(
    private val mapper: RQ.() -> RS,
) : Operation<RQ, RS> {
    override fun RQ.operate() = mapper()
}