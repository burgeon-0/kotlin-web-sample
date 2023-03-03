package org.bg181.kotlin.ui

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * 启动类
 *
 * @author lxc
 * @date 2023/03/03
 */
@SpringBootApplication
class UIApplication

fun main(args: Array<String>) {
    SpringApplication.run(UIApplication::class.java, *args)
}