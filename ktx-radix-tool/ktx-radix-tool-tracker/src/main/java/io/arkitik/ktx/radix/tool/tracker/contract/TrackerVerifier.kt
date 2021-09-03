package io.arkitik.ktx.radix.tool.tracker.contract

import javax.servlet.http.HttpServletRequest

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 30, **Fri Oct, 2020**
 * Project *ktx-radix* [https://arkitik.io]
 */
interface TrackerVerifier {
    fun HttpServletRequest.shouldTrack(): Boolean
}