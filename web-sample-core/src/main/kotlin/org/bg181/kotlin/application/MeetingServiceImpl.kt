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

    override fun createMeeting(meetingDto: MeetingDto) {
        logger.info("CreateMeeting => ${meetingDto}")
        meetingDto.meetingNo = "1"
        meetingDto.startTime = Date()
        meetingDto.endTime = Date()
    }

    override fun updateMeeting(meetingDto: MeetingDto) {
        logger.info("UpdateMeeting => ${meetingDto}")
        meetingDto.startTime = Date()
        meetingDto.endTime = Date()
    }

    override fun deleteMeeting(meetingNo: String) {
        logger.info("DeleteMeeting => ${meetingNo}")
    }

}