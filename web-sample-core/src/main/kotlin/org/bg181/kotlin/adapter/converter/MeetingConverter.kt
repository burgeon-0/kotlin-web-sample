package org.bg181.kotlin.adapter.converter

import org.bg181.kotlin.adapter.vo.param.MeetingCreateParamVo
import org.bg181.kotlin.adapter.vo.param.MeetingUpdateParamVo
import org.bg181.kotlin.adapter.vo.resp.MeetingVo
import org.bg181.kotlin.dto.MeetingDto
import org.mapstruct.Mapper

/**
 * 会议实体转换器
 *
 * @author lxc
 * @date 2023/02/11
 */
@Mapper
interface MeetingConverter {

    /**
     * MeetingCreateParamVo to MeetingDto
     */
    fun toMeetingDto(meetingCreateParamVo: MeetingCreateParamVo): MeetingDto

    /**
     * MeetingUpdateParamVo to MeetingDto
     */
    fun toMeetingDto(meetingUpdateParamVo: MeetingUpdateParamVo): MeetingDto

    /**
     * MeetingDto to MeetingVo
     */
    fun toMeetingVo(meetingDto: MeetingDto): MeetingVo

}