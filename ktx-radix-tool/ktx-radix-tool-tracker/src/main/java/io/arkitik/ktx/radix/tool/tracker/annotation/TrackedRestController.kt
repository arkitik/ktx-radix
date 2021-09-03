package io.arkitik.ktx.radix.tool.tracker.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@RestController
annotation class TrackedRestController(
    @get:AliasFor(annotation = RestController::class)
    val value: String = "",
)