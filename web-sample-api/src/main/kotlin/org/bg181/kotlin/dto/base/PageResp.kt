package org.bg181.kotlin.dto.base

import java.io.Serializable

/**
 * 分页返回
 * TODO 移到 definition 中
 *
 * @author lxc
 * @date 2023/02/11
 */
data class PageResp<T>(

    /**
     * 分页页码
     */
    var pageNo: Int? = null,

    /**
     * 分页大小
     */
    var pageSize: Int? = null,

    /**
     * 总数
     */
    var total: Int? = null,

    /**
     * 总页数
     */
    var totalPage: Int? = null,

    /**
     * 分页数据
     */
    var data: List<T>? = null

) : Serializable