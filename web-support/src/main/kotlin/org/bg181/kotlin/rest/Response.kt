package org.bg181.kotlin.rest

import java.io.Serializable

/**
 * 统一返回
 *
 * @author Sam Lu
 * @date 2023/02/04
 */
data class Response<T>(

    /**
     * 返回编码
     */
    var code: Int? = 0,

    /**
     * 返回消息
     */
    var message: String? = "ok",

    /**
     * 返回数据
     */
    var data: T? = null

) : Serializable