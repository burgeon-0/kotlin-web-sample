package org.bg181.kotlin.dto.base

import java.io.Serializable

/**
 * 分页请求
 * TODO 移到 definition 中
 *
 * @author lxc
 * @date 2023/02/11
 */
data class PageParam(

    /**
     * 分页页码
     */
    var pageNo: Int = 1,

    /**
     * 分页大小
     */
    var pageSize: Int = 10

) : Serializable