package io.quee.ktx.radix.tool.tracker.impl

import io.quee.ktx.radix.tool.tracker.annotation.TrackedMapping
import io.quee.ktx.radix.tool.tracker.annotation.TrackedRestController
import io.quee.ktx.radix.tool.tracker.config.TrackerConfig
import io.quee.ktx.radix.tool.tracker.model.TrackedPath
import io.quee.ktx.radix.tool.tracker.provider.TrackerConfigProvider
import io.quee.ktx.radix.tool.tracker.toTrackedPaths
import org.springframework.beans.factory.BeanFactoryUtils
import org.springframework.context.ApplicationContext
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
class DefaultTrackerConfigProvider(
        trackerConfig: TrackerConfig,
        applicationContext: ApplicationContext
) : TrackerConfigProvider {
    private val trackedPaths: MutableList<TrackedPath> = ArrayList(trackerConfig.tracked)
    override fun paths() = trackedPaths

    init {
        val beansOfTypeIncludingAncestors = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, RequestMappingHandlerMapping::class.java, true, true)
        val requestMappingHandlerMapping = beansOfTypeIncludingAncestors["requestMappingHandlerMapping"]
        val handlerMethods = requestMappingHandlerMapping?.handlerMethods
        handlerMethods?.filter { entry ->
            entry.value.method.annotations.any {
                it.annotationClass.annotations.filterIsInstance<TrackedMapping>().isNotEmpty()
            } || entry.value.beanType.isAnnotationPresent(TrackedRestController::class.java)
        }?.map { entry ->
            entry.key.patternsCondition
                    .patterns  toTrackedPaths {
                        entry.key.methodsCondition.methods.map {
                            HttpMethod.resolve(it.name)!!
                        }
                    }
        }?.forEach { trackedPaths.addAll(it) }
    }
}