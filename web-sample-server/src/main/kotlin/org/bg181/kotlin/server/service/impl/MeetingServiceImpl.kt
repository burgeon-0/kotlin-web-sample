package org.bg181.kotlin.server.service.impl

import cn.hutool.core.util.IdUtil
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.apache.dubbo.config.annotation.DubboService
import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.enums.MeetingStatus
import org.bg181.kotlin.server.dao.adapter.MeetingAdapter
import org.bg181.kotlin.server.dao.entity.Meeting
import org.bg181.kotlin.server.service.converter.ServiceMeetingConverter
import org.bg181.kotlin.support.definition.exception.BaseErrorCode
import org.bg181.kotlin.support.definition.exception.BusinessException
import org.bg181.kotlin.support.definition.model.PageReq
import org.bg181.kotlin.support.definition.model.PageResp
import org.mapstruct.factory.Mappers
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * 会议服务 实现类
 *
 * @author Sam Lu
 * @date 2023/02/04
 */
@DubboService
@Service
class MeetingServiceImpl : MeetingService {

    private val logger = LoggerFactory.getLogger(MeetingService::class.java)
    private val meetingConverter = Mappers.getMapper(ServiceMeetingConverter::class.java)

    @Autowired
    private lateinit var meetingAdapter: MeetingAdapter

    override fun createMeeting(meetingDto: MeetingDto): MeetingDto {
        logger.info("CreateMeeting => ${meetingDto}")

        val meeting = meetingConverter.toMeeting(meetingDto).apply {
            this.meetingNo = IdUtil.getSnowflakeNextId()
            this.status = MeetingStatus.BEFORE.ordinal.toByte()
        }
        meetingAdapter.save(meeting)

        val createdMeeting = meetingAdapter.getById(meeting.id)
        logger.info("CreateMeeting complated => ${createdMeeting}")
        return meetingConverter.toMeetingDto(createdMeeting)
    }

    override fun updateMeeting(meetingDto: MeetingDto): MeetingDto {
        logger.info("UpdateMeeting => ${meetingDto}")

        val meetingId = meetingAdapter.getIdByMeetingNo(meetingDto.meetingNo!!.toLong())
            ?: throw BusinessException(BaseErrorCode.BAD_REQUEST, "meeting not found")

        val meeting = meetingConverter.toMeeting(meetingDto).apply {
            this.id = meetingId
        }
        meetingAdapter.saveOrUpdate(meeting)

        val updatedMeeting = meetingAdapter.getById(meeting.id)
        logger.info("UpdateMeeting complated => ${updatedMeeting}")
        return meetingConverter.toMeetingDto(updatedMeeting)
    }

    override fun deleteMeeting(meetingNo: String) {
        logger.info("DeleteMeeting => ${meetingNo}")

        meetingAdapter.removeByMeetingNo(meetingNo.toLong())
    }

    override fun pageMeetings(pageReq: PageReq): PageResp<MeetingDto> {
        logger.info("PageMeetings => ${pageReq}")

        val pageResult = meetingAdapter.pageRecords(Page<Meeting>().apply {
            this.current = pageReq.pageNo.toLong()
            this.size = pageReq.pageSize.toLong()
        })

        return PageResp<MeetingDto>().apply {
            this.pageNo = pageResult.current.toInt()
            this.pageSize = pageResult.size.toInt()
            this.total = pageResult.total.toInt()
            this.totalPage = pageResult.pages.toInt()
            this.data = meetingConverter.toMeetingDtos(pageResult.records)
        }
    }

}