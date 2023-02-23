package org.bg181.kotlin.core

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
@MapperScan("org.bg181.kotlin.core.dao.mapper")
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}