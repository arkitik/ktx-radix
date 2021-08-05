package io.quee.ktx.radix.starter.logger.webflux

import io.quee.ktx.radix.port.logger.KtxLoggerPortContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
@Configuration
@Import(value = [KtxLoggerPortContext::class])
class KtxNettyLoggerAutoConfiguration