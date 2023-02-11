package org.bg181.kotlin.core.web.vo.param

import java.io.Serializable
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * 预约会议
 *
 * @author lxc
 * @date 2023/02/09
 */
data class MeetingCreateParamVo(

    /**
     * 会议主题
     */
    @field:NotBlank
    @field:Size(max = 30)
    var title: String? = null,

    /**
     * 会议内容
     */
    @field:Size(max = 200)
    var content: String? = null,

    /**
     * 开始时间
     */
    @field:NotNull
    var startTime: Date? = null,

    /**
     * 结束时间
     */
    @field:NotNull
    var endTime: Date? = null

) : Serializable
