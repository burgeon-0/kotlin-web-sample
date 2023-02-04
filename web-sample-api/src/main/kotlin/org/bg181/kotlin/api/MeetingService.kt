package org.bg181.kotlin.api

import org.bg181.kotlin.dto.MeetingDto

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
interface MeetingService {

    /**
     * 预约会议
     */
    fun createMeeting(meeting: MeetingDto)

    /**
     * 修改会议
     */
    fun updateMeeting(meeting: MeetingDto)

    /**
     * 取消会议
     */
    fun deleteMeeting(meetingNo: String)

}