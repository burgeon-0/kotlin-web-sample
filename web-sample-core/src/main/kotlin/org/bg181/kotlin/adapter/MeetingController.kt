package org.bg181.kotlin.adapter

import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.rest.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
@RestController
@RequestMapping("/api/meetings")
class MeetingController {

    @Autowired
    private lateinit var meetingService: MeetingService

    /**
     * 预约会议
     */
    @PostMapping
    fun createMeeting(meeting: MeetingDto): Response<MeetingDto> {
        meetingService.createMeeting(meeting)
        return Response()
    }

}