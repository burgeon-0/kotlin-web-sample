package org.bg181.kotlin.core.web.controller

import org.bg181.kotlin.core.web.converter.WebMeetingConverter
import org.bg181.kotlin.core.web.vo.param.MeetingCreateParamVo
import org.bg181.kotlin.core.web.vo.param.MeetingUpdateParamVo
import org.bg181.kotlin.core.web.vo.resp.MeetingVo
import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.base.PageParam
import org.bg181.kotlin.dto.base.PageResp
import org.bg181.kotlin.support.definition.dto.Resp
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 会议控制器
 *
 * @author Sam Lu
 * @date 2023/02/04
 */
@RestController
@RequestMapping("/api/meetings")
class MeetingController {

    private val meetingConverter = Mappers.getMapper(WebMeetingConverter::class.java)

    @Autowired
    private lateinit var meetingService: MeetingService

    /**
     * 预约会议
     */
    @PostMapping
    fun createMeeting(
        @Valid @RequestBody meetingCreateParamVo: MeetingCreateParamVo
    ): Resp<MeetingVo> {
        val inMeetingDto = meetingConverter.toMeetingDto(meetingCreateParamVo);
        val outMeetingDto = meetingService.createMeeting(inMeetingDto)
        return Resp<MeetingVo>().apply {
            data = meetingConverter.toMeetingVo(outMeetingDto)
        }
    }

    /**
     * 修改会议
     */
    @PutMapping("/{meetingNo}")
    fun updateMeeting(
        @PathVariable meetingNo: String,
        @Valid @RequestBody meetingUpdateParamVo: MeetingUpdateParamVo
    ): Resp<MeetingVo> {
        val inMeetingDto = meetingConverter.toMeetingDto(meetingUpdateParamVo).apply {
            this.meetingNo = meetingNo
        };
        val outMeetingDto = meetingService.updateMeeting(inMeetingDto)
        return Resp<MeetingVo>().apply {
            data = meetingConverter.toMeetingVo(outMeetingDto)
        }
    }

    /**
     * 删除会议
     */
    @DeleteMapping("/{meetingNo}")
    fun deleteMeeting(@PathVariable meetingNo: String): Resp<Unit> {
        meetingService.deleteMeeting(meetingNo)
        return Resp<Unit>()
    }

    /**
     * 分页查询会议
     */
    @GetMapping
    fun pageMeetings(@ModelAttribute pageParam: PageParam): Resp<PageResp<MeetingVo>?> {
        return Resp<PageResp<MeetingVo>?>().apply {
            this.data = meetingConverter.toPageMeetingVos(meetingService.pageMeetings(pageParam))
        }
    }

}