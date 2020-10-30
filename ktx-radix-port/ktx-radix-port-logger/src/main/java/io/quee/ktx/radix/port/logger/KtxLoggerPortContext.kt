package io.quee.ktx.radix.port.logger

import io.quee.ktx.radix.port.logger.config.KtxLoggerConfig
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.BodyFilters
import org.zalando.logbook.DefaultHttpLogWriter
import org.zalando.logbook.Logbook

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
@Configuration
@EnableConfigurationProperties(value = [KtxLoggerConfig::class])
class KtxLoggerPortContext {
    @Bean
    @ConditionalOnMissingBean
    fun logbook(
            ktxLoggerConfig: KtxLoggerConfig
    ): Logbook {
        return Logbook.builder()
                .bodyFilter(BodyFilters.replaceJsonStringProperty(ktxLoggerConfig.maskedKeys, ktxLoggerConfig.mask))
                .formatter(ktxLoggerConfig.formatter.formatter)
                .writer(DefaultHttpLogWriter(LoggerFactory.getLogger(ktxLoggerConfig.loggerName), ktxLoggerConfig.level))
                .build()
    }
}