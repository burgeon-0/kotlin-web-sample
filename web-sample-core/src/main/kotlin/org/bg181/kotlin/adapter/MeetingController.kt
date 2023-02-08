package org.bg181.kotlin.adapter

import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.rest.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
    fun createMeeting(@RequestBody meeting: MeetingDto): Response<MeetingDto> {
        meetingService.createMeeting(meeting)
        return Response<MeetingDto>().apply {
            data = meeting
        }
    }

    /**
     * 修改会议
     */
    @PutMapping
    fun updateMeeting(@RequestBody meeting: MeetingDto): Response<MeetingDto> {
        meetingService.updateMeeting(meeting)
        return Response<MeetingDto>().apply {
            data = meeting
        }
    }

    /**
     * 删除会议
     */
    @DeleteMapping("/{meetingNo}")
    fun deleteMeeting(@PathVariable meetingNo: String): Response<Unit> {
        meetingService.deleteMeeting(meetingNo)
        return Response<Unit>()
    }

}