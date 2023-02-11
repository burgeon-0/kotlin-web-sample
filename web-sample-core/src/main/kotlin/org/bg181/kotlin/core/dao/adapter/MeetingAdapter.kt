package org.bg181.kotlin.core.dao.adapter

import com.baomidou.mybatisplus.extension.service.IService
import org.bg181.kotlin.core.dao.entity.Meeting

/**
 * 会议 Adapter 接口
 *
 * @author lxc
 * @date 2023/02/11
 */
interface MeetingAdapter : IService<Meeting> {

    /**
     * 根据会议编号，查询会议ID
     */
    fun getIdByMeetingNo(meetingNo: Long): Int?

    /**
     * 根据会议编号，查询会议
     */
    fun getByMeetingNo(meetingNo: Long): Meeting?

    /**
     * 根据会议编号，删除会议
     */
    fun removeByMeetingNo(meetingNo: Long)

}