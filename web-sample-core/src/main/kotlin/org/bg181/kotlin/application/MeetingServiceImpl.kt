package org.bg181.kotlin.application

import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
@Service
class MeetingServiceImpl : MeetingService {

    private val logger = LoggerFactory.getLogger(MeetingService::class.java)

    override fun createMeeting(meeting: MeetingDto) {
        logger.info("CreateMeeting: ${meeting.title}, ${meeting.content}")
    }

    override fun updateMeeting(meeting: MeetingDto) {
        TODO("Not yet implemented")
    }

    override fun deleteMeeting(meetingNo: String) {
        TODO("Not yet implemented")
    }

}