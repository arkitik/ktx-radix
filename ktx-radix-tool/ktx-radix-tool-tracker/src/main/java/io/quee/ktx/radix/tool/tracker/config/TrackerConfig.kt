package io.quee.ktx.radix.tool.tracker.config

import io.quee.ktx.radix.tool.tracker.model.TrackedPath
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.http.HttpMethod

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
@ConfigurationProperties("ktx.tracker.config")
@ConstructorBinding
data class TrackerConfig(
        val tracked: List<TrackedPathImpl> = arrayListOf()
) {
    @ConstructorBinding
    data class TrackedPathImpl(
            override val path: String,
            override val methods: Set<HttpMethod> = HashSet()
    ) : TrackedPath
}