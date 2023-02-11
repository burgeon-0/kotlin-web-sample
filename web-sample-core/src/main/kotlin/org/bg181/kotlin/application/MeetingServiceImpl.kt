package org.bg181.kotlin.application

import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

/**
 * 会议服务 实现类
 *
 * @author Sam Lu
 * @date 2023/02/04
 */
@Service
class MeetingServiceImpl : MeetingService {

    private val logger = LoggerFactory.getLogger(MeetingService::class.java)

    override fun createMeeting(meetingDto: MeetingDto): MeetingDto {
        logger.info("CreateMeeting => ${meetingDto}")
        meetingDto.meetingNo = "1"
        return meetingDto
    }

    override fun updateMeeting(meetingDto: MeetingDto): MeetingDto {
        logger.info("UpdateMeeting => ${meetingDto}")
        return meetingDto
    }

    override fun deleteMeeting(meetingNo: String) {
        logger.info("DeleteMeeting => ${meetingNo}")
    }

}