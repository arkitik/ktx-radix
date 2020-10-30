package io.quee.ktx.radix.port.logger.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue
import org.zalando.logbook.DefaultHttpLogWriter

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "ktx.logger")
data class KtxLoggerConfig(
        @DefaultValue("DEFAULT") val formatter: FormatterType,
        @DefaultValue("########") val mask: String,
        val maskedKeys: Set<String> = HashSet(),
        val loggerName: Class<*> = KtxLoggerConfig::class.java,
        @DefaultValue("DEBUG") val level: DefaultHttpLogWriter.Level
)