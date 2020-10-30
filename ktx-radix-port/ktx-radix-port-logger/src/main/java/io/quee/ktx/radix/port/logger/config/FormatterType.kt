package io.quee.ktx.radix.port.logger.config

import org.zalando.logbook.*

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [Quee.IO]
 */
enum class FormatterType(val formatter: HttpLogFormatter) {
    DEFAULT(DefaultHttpLogFormatter()),
    JSON(JsonHttpLogFormatter()),
    CURL(CurlHttpLogFormatter()),
    SPLUNK(SplunkHttpLogFormatter())
}