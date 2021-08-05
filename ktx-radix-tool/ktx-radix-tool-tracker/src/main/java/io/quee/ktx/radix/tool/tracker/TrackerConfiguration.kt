package io.quee.ktx.radix.tool.tracker

import io.quee.ktx.radix.tool.tracker.config.TrackerConfig
import io.quee.ktx.radix.tool.tracker.contract.TrackerVerifier
import io.quee.ktx.radix.tool.tracker.executer.TrackerExecutor
import io.quee.ktx.radix.tool.tracker.filter.TrackerRequestFilter
import io.quee.ktx.radix.tool.tracker.impl.DefaultTrackerConfigProvider
import io.quee.ktx.radix.tool.tracker.impl.DefaultTrackerVerifier
import io.quee.ktx.radix.tool.tracker.impl.EmptyTrackerExecutor
import io.quee.ktx.radix.tool.tracker.provider.TrackerConfigProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.AntPathMatcher
import org.springframework.util.PathMatcher

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
@Configuration
@EnableConfigurationProperties(value = [TrackerConfig::class])
class TrackerConfiguration {

    @Bean
    @ConditionalOnMissingBean(value = [PathMatcher::class])
    fun pathMatcher(): PathMatcher = AntPathMatcher()

    @Bean
    @ConditionalOnMissingBean(value = [TrackerExecutor::class])
    fun trackerExecutor(): TrackerExecutor = EmptyTrackerExecutor()

    @Bean
    @ConditionalOnMissingBean(value = [TrackerConfigProvider::class])
    fun trackerConfigProvider(
        trackerConfig: TrackerConfig,
        applicationContext: ApplicationContext,
    ): TrackerConfigProvider = DefaultTrackerConfigProvider(trackerConfig, applicationContext)

    @Bean
    @ConditionalOnMissingBean(value = [TrackerVerifier::class])
    fun trackerVerifier(
        trackerConfigProvider: TrackerConfigProvider,
        pathMatcher: PathMatcher,
    ): TrackerVerifier = DefaultTrackerVerifier(trackerConfigProvider, pathMatcher)

    @Bean
    fun trackerRequestFilter(
        trackerExecutor: TrackerExecutor,
        trackerVerifier: TrackerVerifier,
    ) = TrackerRequestFilter(trackerExecutor, trackerVerifier)
}