package io.quee.ktx.radix.tool.tracker.impl

import io.quee.ktx.radix.tool.tracker.contract.TrackerVerifier
import io.quee.ktx.radix.tool.tracker.provider.TrackerConfigProvider
import org.springframework.http.HttpMethod
import org.springframework.util.PathMatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
class DefaultTrackerVerifier(
    private val trackerConfigProvider: TrackerConfigProvider,
    private val pathMatcher: PathMatcher,
) : TrackerVerifier {
    override fun HttpServletRequest.shouldTrack(): Boolean {
        HttpServletRequestWrapper(this)
        return trackerConfigProvider
            .paths()
            .filter {
                it.methods.contains(HttpMethod.resolve(method))
            }.any {
                with(pathMatcher) {
                    match(it.path, servletPath) && it.methods == it.methods
                }
            }
    }
}