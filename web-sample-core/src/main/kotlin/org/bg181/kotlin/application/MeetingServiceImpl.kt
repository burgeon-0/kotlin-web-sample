package org.bg181.kotlin.application

import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
@Service
class MeetingServiceImpl : MeetingService {

    private val logger = LoggerFactory.getLogger(MeetingService::class.java)

    override fun createMeeting(meeting: MeetingDto) {
        logger.info("CreateMeeting => title: ${meeting.title}, content: ${meeting.content}")
        meeting.meetingNo = "1"
        meeting.startTime = Date()
        meeting.endTime = Date()
    }

    override fun updateMeeting(meeting: MeetingDto) {
        TODO("Not yet implemented")
    }

    override fun deleteMeeting(meetingNo: String) {
        TODO("Not yet implemented")
    }

}