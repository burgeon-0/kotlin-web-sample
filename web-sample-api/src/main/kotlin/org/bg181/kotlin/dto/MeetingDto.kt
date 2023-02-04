package org.bg181.kotlin.dto

import java.io.Serializable
import java.util.*

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
class MeetingDto : Serializable {

    /**
     * 会议编号
     */
    var meetingNo: String? = null

    /**
     * 会议主题
     */
    var title: String? = null

    /**
     * 会议内容
     */
    var content: String? = null

    /**
     * 开始时间
     */
    var startTime: Date? = null

    /**
     * 结束时间
     */
    val endTime: Date? = null

}