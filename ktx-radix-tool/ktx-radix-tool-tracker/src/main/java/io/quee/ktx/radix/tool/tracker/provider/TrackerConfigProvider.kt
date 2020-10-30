package io.quee.ktx.radix.tool.tracker.provider

import io.quee.ktx.radix.tool.tracker.model.TrackedPath

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
interface TrackerConfigProvider {
    fun paths(): List<TrackedPath>
}