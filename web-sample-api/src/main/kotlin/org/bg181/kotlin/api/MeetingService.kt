package org.bg181.kotlin.api

import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.support.definition.model.PageReq
import org.bg181.kotlin.support.definition.model.PageResp

/**
 * 会议服务
 *
 * @author Sam Lu
 * @date 2023/02/04
 */
interface MeetingService {

    /**
     * 预约会议
     */
    fun createMeeting(meetingDto: MeetingDto): MeetingDto

    /**
     * 修改会议
     */
    fun updateMeeting(meetingDto: MeetingDto): MeetingDto

    /**
     * 取消会议
     */
    fun deleteMeeting(meetingNo: String)

    /**
     * 分页查询会议
     */
    fun pageMeetings(pageReq: PageReq): PageResp<MeetingDto>

}