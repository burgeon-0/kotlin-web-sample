package org.bg181.kotlin.core.dao.adapter.impl

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.bg181.kotlin.core.dao.adapter.MeetingAdapter
import org.bg181.kotlin.core.dao.entity.Meeting
import org.bg181.kotlin.core.dao.mapper.MeetingMapper
import org.springframework.stereotype.Repository

/**
 * 会议 Adapter 实现类
 *
 * @author lxc
 * @date 2023/02/11
 */
@Repository
open class MeetingAdapterImpl : ServiceImpl<MeetingMapper, Meeting>(), MeetingAdapter {

    override fun getIdByMeetingNo(meetingNo: Long): Int? {
        val queryWrapper = KtQueryWrapper(Meeting())
            .select(Meeting::id)
            .eq(Meeting::meetingNo, meetingNo)
        return super.baseMapper.selectOne(queryWrapper)?.id;
    }

    override fun getByMeetingNo(meetingNo: Long): Meeting? {
        val queryWrapper = KtQueryWrapper(Meeting())
            .eq(Meeting::meetingNo, meetingNo)
        return super.baseMapper.selectOne(queryWrapper);
    }

    override fun removeByMeetingNo(meetingNo: Long) {
        val meetingId = this.getIdByMeetingNo(meetingNo)
        val meeting = Meeting().apply {
            this.id = meetingId
        }
        super.baseMapper.deleteById(meeting)
    }

}