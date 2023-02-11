package org.bg181.kotlin.core.web.vo.resp

import org.bg181.kotlin.enums.MeetingStatus
import java.io.Serializable
import java.util.*

/**
 * 会议返回数据
 *
 * @author lxc
 * @date 2023/02/09
 */
data class MeetingVo(

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
    var status: Int? = null

) : Serializable