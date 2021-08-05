package io.quee.ktx.radix.tool.tracker

import io.quee.ktx.radix.tool.tracker.config.TrackerConfig
import io.quee.ktx.radix.tool.tracker.model.TrackedPath
import org.springframework.http.HttpMethod

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */

infix fun String.toTrackedPath(methods: Iterable<HttpMethod>): TrackedPath =
    TrackerConfig.TrackedPathImpl(this, methods.toSet())

infix fun Collection<String>.toTrackedPaths(methods: Iterable<HttpMethod>) = map {
    it.toTrackedPath(methods)
}

infix fun Collection<String>.toTrackedPaths(provider: () -> List<HttpMethod>) =
    toTrackedPaths(provider())
