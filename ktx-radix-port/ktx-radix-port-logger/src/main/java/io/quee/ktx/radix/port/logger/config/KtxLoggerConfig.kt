package io.quee.ktx.radix.port.logger.config

import org.slf4j.event.Level
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "ktx.logger")
data class KtxLoggerConfig(
    @DefaultValue("DEFAULT") val formatter: FormatterType,
    @DefaultValue("########") val mask: String,
    @Deprecated("Use ignored.fields instead")
    val maskedKeys: Set<String> = HashSet(),
    val loggerName: Class<*> = KtxLoggerConfig::class.java,
    @DefaultValue("DEBUG") val level: Level,
    val ignored: IgnoredConfig = IgnoredConfig(fields = maskedKeys),
) {
    @ConstructorBinding
    data class IgnoredConfig(
        val urls: Set<String> = HashSet(),
        val fields: Set<String> = HashSet(),
    )
}