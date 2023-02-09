package org.bg181.kotlin.adapter.controller

import org.bg181.kotlin.adapter.converter.MeetingConverter
import org.bg181.kotlin.adapter.vo.param.MeetingCreateParamVo
import org.bg181.kotlin.adapter.vo.param.MeetingUpdateParamVo
import org.bg181.kotlin.adapter.vo.resp.MeetingVo
import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.rest.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
    fun createMeeting(
        @Valid @RequestBody meetingCreateParamVo: MeetingCreateParamVo
    ): Response<MeetingVo> {
        val inMeetingDto = MeetingConverter.toMeetingDto(meetingCreateParamVo);
        val outMeetingDto = meetingService.createMeeting(inMeetingDto)
        return Response<MeetingVo>().apply {
            data = MeetingConverter.toMeetingVo(outMeetingDto)
        }
    }

    /**
     * 修改会议
     */
    @PutMapping("/{meetingNo}")
    fun updateMeeting(
        @PathVariable meetingNo: String,
        @Valid @RequestBody meetingUpdateParamVo: MeetingUpdateParamVo
    ): Response<MeetingVo> {
        val inMeetingDto = MeetingConverter.toMeetingDto(meetingUpdateParamVo).apply {
            this.meetingNo = meetingNo
        };
        val outMeetingDto = meetingService.updateMeeting(inMeetingDto)
        return Response<MeetingVo>().apply {
            data = MeetingConverter.toMeetingVo(outMeetingDto)
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