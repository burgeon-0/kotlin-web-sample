package org.bg181.kotlin.server.web.converter

import org.bg181.kotlin.server.web.vo.param.MeetingCreateParamVo
import org.bg181.kotlin.server.web.vo.param.MeetingUpdateParamVo
import org.bg181.kotlin.server.web.vo.resp.MeetingVo
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.support.definition.model.PageResp
import org.mapstruct.*

/**
 * 会议实体转换器
 *
 * @author lxc
 * @date 2023/02/11
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class WebMeetingConverter {

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

    /**
     * PageResp<MeetingDto> to PageResp<MeetingVo>
     *
     * @param pageResp
     * @return
     */
    @Mapping(target = "data", ignore = true)
    abstract fun toPageMeetingVos(pageResp: PageResp<MeetingDto>): PageResp<MeetingVo>

    @AfterMapping
    protected fun afterToPageMeetingVos(
        pageResp: PageResp<MeetingDto>,
        @MappingTarget newPageResp: PageResp<MeetingVo>
    ) {
        newPageResp.data = pageResp.data?.map { it ->
            toMeetingVo(it)
        }
    }

}