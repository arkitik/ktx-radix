package io.quee.ktx.radix.tool.tracker.filter

import io.quee.ktx.radix.tool.tracker.contract.TrackerVerifier
import io.quee.ktx.radix.tool.tracker.executer.TrackerExecutor
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
class TrackerRequestFilter(
    private val trackerExecutor: TrackerExecutor,
    private val trackerVerifier: TrackerVerifier,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        filterChain.doFilter(request, response)
        trackerExecutor.execute(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest) =
        with(trackerVerifier) {
            !request.shouldTrack()
        }
}