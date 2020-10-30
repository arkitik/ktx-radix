package io.quee.ktx.radix.tool.tracker.executer

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
interface TrackerExecutor {
    fun execute(
            request: HttpServletRequest,
            response: HttpServletResponse
    )
}