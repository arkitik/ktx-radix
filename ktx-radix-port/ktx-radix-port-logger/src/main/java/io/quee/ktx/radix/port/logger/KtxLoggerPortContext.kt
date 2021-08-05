package io.quee.ktx.radix.port.logger

import io.quee.ktx.radix.port.logger.config.KtxLoggerConfig
import io.quee.ktx.radix.port.logger.function.KtxHttpLogWriter
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.*
import org.zalando.logbook.json.JsonBodyFilters
import java.util.*

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
@Configuration
@EnableConfigurationProperties(value = [KtxLoggerConfig::class])
class KtxLoggerPortContext {
    @Bean
    @ConditionalOnMissingBean
    fun logbook(
        ktxLoggerConfig: KtxLoggerConfig,
    ): Logbook =
        with(Logbook.builder()) {
            correlationId { UUID.randomUUID().toString() }
            bodyFilter(BodyFilters.replaceFormUrlEncodedProperty(ktxLoggerConfig.ignored.fields, ktxLoggerConfig.mask))
            bodyFilter(JsonBodyFilters.replaceJsonStringProperty(ktxLoggerConfig.ignored.fields, ktxLoggerConfig.mask))
            headerFilter(HeaderFilters.replaceHeaders(ktxLoggerConfig.ignored.fields, ktxLoggerConfig.mask))
            headerFilter(
                HeaderFilters.replaceCookies(
                    { ktxLoggerConfig.ignored.fields.contains(it) },
                    ktxLoggerConfig.mask
                )
            )
            queryFilter(
                QueryFilters.replaceQuery(
                    { ktxLoggerConfig.ignored.fields.contains(it) },
                    ktxLoggerConfig.mask
                )
            )
            condition(
                Conditions.exclude(
                    ktxLoggerConfig.ignored.urls
                        .map {
                            Conditions.requestTo(it)
                        }
                )
            )
            sink(
                DefaultSink(
                    ktxLoggerConfig.formatter.formatter,
                    KtxHttpLogWriter(
                        LoggerFactory.getLogger(
                            ktxLoggerConfig.loggerName
                        ),
                        Level.DEBUG
                    )
                )
            )
        }.build()
}