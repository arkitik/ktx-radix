package io.quee.ktx.radix.tool.tracker.impl

import io.quee.ktx.radix.tool.tracker.executer.TrackerExecutor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.util.StreamUtils
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://quee.io]
 */
class EmptyTrackerExecutor : TrackerExecutor {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    override fun execute(request: HttpServletRequest, response: HttpServletResponse) {
        logger.info(
            "Request: {}, Response: {}",
            StreamUtils.copyToString(ContentCachingRequestWrapper(request).inputStream, StandardCharsets.UTF_8),
            StreamUtils.copyToString(ContentCachingResponseWrapper(response).contentInputStream, StandardCharsets.UTF_8)
        )
    }
}