package io.arkitik.ktx.radix.starter.logger.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 12, **Fri February, 2021**
 * Project *ktx-radix* [https://arkitik.io]
 */
@SpringBootApplication
class SampleFluxApp


fun main(args: Array<String>) {
    runApplication<SampleFluxApp>(*args)
}