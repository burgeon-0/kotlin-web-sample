package org.bg181.kotlin.adapter.converter

import org.bg181.kotlin.adapter.vo.param.MeetingCreateParamVo
import org.bg181.kotlin.adapter.vo.param.MeetingUpdateParamVo
import org.bg181.kotlin.adapter.vo.resp.MeetingVo
import org.bg181.kotlin.common.convertTo
import org.bg181.kotlin.dto.MeetingDto
import org.springframework.beans.BeanUtils

/**
 * 会议实体转换器
 *
 * @author lxc
 * @date 2023/02/09
 */
class MeetingConverter {

    companion object {

        /**
         * MeetingCreateParamVo to MeetingDto
         */
        fun toMeetingDto(meetingCreateParamVo: MeetingCreateParamVo): MeetingDto {
            return meetingCreateParamVo.convertTo(MeetingDto::class.java)
        }

        /**
         * MeetingUpdateParamVo to MeetingDto
         */
        fun toMeetingDto(meetingUpdateParamVo: MeetingUpdateParamVo): MeetingDto {
            return meetingUpdateParamVo.convertTo(MeetingDto::class.java)
        }

        /**
         * MeetingDto to MeetingVo
         */
        fun toMeetingVo(meetingDto: MeetingDto): MeetingVo {
            return meetingDto.convertTo(MeetingVo::class.java)
        }

    }

}