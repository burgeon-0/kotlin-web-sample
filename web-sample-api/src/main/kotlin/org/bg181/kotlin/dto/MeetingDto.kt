package org.bg181.kotlin.dto

import org.bg181.kotlin.enums.MeetingStatus
import java.io.Serializable
import java.util.*

/**
 * 会议实体
 *
 * @author Sam Lu
 * @date 2023/02/04
 */
data class MeetingDto(

    /**
     * 会议编号
     */
    var meetingNo: String? = null,

    /**
     * 会议主题
     */
    var title: String? = null,

    /**
     * 会议内容
     */
    var content: String? = null,

    /**
     * 开始时间
     */
    var startTime: Date? = null,

    /**
     * 结束时间
     */
    var endTime: Date? = null,

    /**
     * 会议状态
     */
    var status: MeetingStatus? = null

) : Serializable