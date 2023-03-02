package org.bg181.kotlin.server.service.converter

import org.bg181.kotlin.server.dao.entity.Meeting
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.enums.MeetingStatus
import org.mapstruct.*

/**
 * 会议实体转换器
 *
 * @author lxc
 * @date 2023/02/11
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class ServiceMeetingConverter {

    /**
     * MeetingDto to Meeting
     */
    @Mapping(target = "meetingNo", ignore = true)
    @Mapping(target = "status", ignore = true)
    abstract fun toMeeting(meetingDto: MeetingDto): Meeting

    @AfterMapping
    protected fun afterToMeeting(meetingDto: MeetingDto, @MappingTarget meeting: Meeting) {
        meeting.meetingNo = meetingDto.meetingNo?.toLongOrNull()
        meeting.status = meetingDto.status?.ordinal?.toByte()
    }

    /**
     * Meeting to MeetingDto
     */
    @Mapping(target = "meetingNo", ignore = true)
    @Mapping(target = "status", ignore = true)
    abstract fun toMeetingDto(meeting: Meeting): MeetingDto

    @AfterMapping
    protected fun afterToMeetingDto(meeting: Meeting, @MappingTarget meetingDto: MeetingDto) {
        meetingDto.meetingNo = meeting.meetingNo?.toString()
        meetingDto.status = MeetingStatus.valueOf(meeting.status?.toInt() ?: -1)
    }

    /**
     * List<Meeting> to List<MeetingDto>
     */
    abstract fun toMeetingDtos(meetings: List<Meeting>): List<MeetingDto>

}