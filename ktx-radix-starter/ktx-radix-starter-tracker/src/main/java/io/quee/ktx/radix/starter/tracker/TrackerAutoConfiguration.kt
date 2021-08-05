package io.quee.ktx.radix.starter.tracker

import io.quee.ktx.radix.tool.tracker.TrackerConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
@Configuration
@Import(value = [TrackerConfiguration::class])
class TrackerAutoConfiguration