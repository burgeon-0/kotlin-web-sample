package org.bg181.kotlin.core.dao

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.config.OutputFile
import com.baomidou.mybatisplus.generator.config.rules.DateType
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import com.baomidou.mybatisplus.generator.fill.Column
import java.util.*
import java.util.function.Consumer

/**
 * 代码自动生成
 *
 * @author lxc
 * @date 2023/02/11
 */
fun main() {
    val projectDir = System.getProperty("user.dir")
    val modulName = "web-sample-core"
    val baseDir = "$projectDir/$modulName"
    FastAutoGenerator.create("jdbc:mysql://localhost:3306/kotlin_web_sample", "root", "root")
        .globalConfig(Consumer {
            it.author("lxc") // 设置作者
                .commentDate("yyyy/MM/dd") // 指定注释中 @date 的时间格式
                .enableKotlin() // 开启 kotlin 模式
                .disableOpenDir() // 禁止打开输出目录
                .outputDir("$baseDir/src/main/kotlin") // 指定输出目录
                .dateType(DateType.ONLY_DATE) // 指定 entity 类中，日期的类型为 java.util.Date
        })
        .packageConfig(Consumer {
            it.parent("org.bg181.kotlin.core.dao") // 设置父包名
                .entity("entity") // entity 的包名
                .pathInfo(
                    Collections.singletonMap(
                        OutputFile.xml,
                        "$baseDir/src/main/resources/META-INF/mapper"
                    )
                ) // 设置 mapperXml 的生成路径
        })
        .strategyConfig(Consumer {
            it.addInclude("t_meeting") // 设置需要生成的表名
                .addTablePrefix("t_") // 设置需要过滤的表前缀
                .entityBuilder().enableFileOverride() // 覆盖已有的 entity 文件
                .logicDeleteColumnName("deleted") // 设置逻辑删除字段
                .addTableFills(Column("deleted", FieldFill.INSERT)) // 自动插入 deleted
                .addTableFills(Column("create_time", FieldFill.INSERT)) // 自动插入 创建时间
                .addTableFills(Column("update_time", FieldFill.INSERT_UPDATE)) // 自动插入和更新 更新时间
        })
        .templateConfig(Consumer {
            it.controller("") // 不生成 Controller
                .service("") // 不生成 Service
                .serviceImpl("") // 不生成 ServiceImpl
        })
        .templateEngine(FreemarkerTemplateEngine()) // 使用 freemarker 模板引擎，默认是 velocity 模板引擎
        .execute()
}