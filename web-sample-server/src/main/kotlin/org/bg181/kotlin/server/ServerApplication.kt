package org.bg181.kotlin.server

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * 启动类
 *
 * @author Sam Lu
 * @date 2023/02/06
 */
@SpringBootApplication
@MapperScan("org.bg181.kotlin.server.dao.mapper")
@EnableDubbo
class ServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ServerApplication::class.java, *args)
}