package org.bg181.kotlin.adapter.converter

import org.bg181.kotlin.adapter.vo.param.MeetingCreateParamVo
import org.bg181.kotlin.adapter.vo.param.MeetingUpdateParamVo
import org.bg181.kotlin.adapter.vo.resp.MeetingVo
import org.bg181.kotlin.dto.MeetingDto
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

/**
 * 会议实体转换器
 *
 * @author lxc
 * @date 2023/02/11
 */
@Mapper
abstract class MeetingConverter {

    /**
     * MeetingCreateParamVo to MeetingDto
     */
    abstract fun toMeetingDto(meetingCreateParamVo: MeetingCreateParamVo): MeetingDto

    /**
     * MeetingUpdateParamVo to MeetingDto
     */
    abstract fun toMeetingDto(meetingUpdateParamVo: MeetingUpdateParamVo): MeetingDto

    /**
     * MeetingDto to MeetingVo
     */
    @Mapping(target = "status", ignore = true)
    abstract fun toMeetingVo(meetingDto: MeetingDto): MeetingVo

    @AfterMapping
    protected fun afterToMeetingVo(meetingDto: MeetingDto, @MappingTarget meetingVo: MeetingVo) {
        meetingVo.status = meetingDto.status?.ordinal
    }

}