package org.bg181.kotlin.server.service

import cn.hutool.core.date.DateUtil
import org.apache.dubbo.config.annotation.DubboReference
import org.bg181.kotlin.api.MeetingService
import org.bg181.kotlin.dto.MeetingDto
import org.bg181.kotlin.server.ServerApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*

/**
 * 启动需要指定 jvm 参数：
 * --add-opens java.base/java.lang=ALL-UNNAMED
 * --add-opens java.base/java.math=ALL-UNNAMED
 *
 * @author lxc
 * @date 2023/05/06
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(ServerApplication::class))
class MeetingServiceTest {

    @DubboReference
    private lateinit var meetingService: MeetingService

    @Test
    fun testCreateMeeting() {
        val dateFormat = "yyyy-MM-dd HH:mm:ss"
        val startTime = DateUtil.parse("2023-05-06 11:00:00", dateFormat).toJdkDate()
        val endTime = DateUtil.parse("2023-05-06 12:00:00", dateFormat).toJdkDate()
        meetingService.createMeeting(
            MeetingDto().apply {
                this.title = "测试会议"
                this.content = "测试内容"
                this.startTime = startTime
                this.endTime = endTime
            }
        )
    }

}