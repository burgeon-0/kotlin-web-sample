package org.bg181.kotlin.adapter

import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.rest.Response
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
@RestController("/api/meetings")
class MeetingController {

    //val meetingService: MeetingService

    /**
     * 预约会议
     */
    @PostMapping
    fun createMeeting(meeting: MeetingDto): Response<MeetingDto> {
        return Response()
    }

}