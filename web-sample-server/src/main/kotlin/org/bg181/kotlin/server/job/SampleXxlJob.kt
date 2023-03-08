package org.bg181.kotlin.server.job

import com.xxl.job.core.handler.annotation.XxlJob
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

/**
 * XXL Job 样例
 *
 * @author lxc
 * @date 2023/03/08
 */
@Component
class SampleXxlJob {

    private val logger = LoggerFactory.getLogger(SampleXxlJob::class.java)

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    @Throws(Exception::class)
    fun demoJobHandler() {
        logger.info("XXL-JOB, Hello World.")

        for (i in 0..4) {
            logger.info("beat at: $i")
            TimeUnit.SECONDS.sleep(2)
        }
    }

}