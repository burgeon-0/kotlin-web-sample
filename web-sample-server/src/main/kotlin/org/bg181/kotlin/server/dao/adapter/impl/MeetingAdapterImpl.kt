package org.bg181.kotlin.server.dao.adapter.impl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.bg181.kotlin.server.dao.adapter.MeetingAdapter
import org.bg181.kotlin.server.dao.entity.Meeting
import org.bg181.kotlin.server.dao.mapper.MeetingMapper
import org.springframework.stereotype.Repository

/**
 * 会议 Adapter 实现类
 *
 * @author lxc
 * @date 2023/02/11
 */
@Repository
class MeetingAdapterImpl : ServiceImpl<MeetingMapper, Meeting>(), MeetingAdapter {

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
        val meetingId = this.getIdByMeetingNo(meetingNo) ?: return
        val meeting = Meeting().apply {
            this.id = meetingId
        }
        // 需要注意此处有坑：如果 delete 时传入的参数不是 entity，update_time 将得不到更新
        super.baseMapper.deleteById(meeting)
    }

    override fun pageRecords(page: IPage<Meeting>): IPage<Meeting> {
        val queryWrapper = KtQueryWrapper(Meeting())
        return super.baseMapper.selectPage(page, queryWrapper);
    }

}