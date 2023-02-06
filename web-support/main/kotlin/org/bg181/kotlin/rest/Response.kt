package org.bg181.kotlin.rest

/**
 * @author Sam Lu
 * @date 2023/02/04
 */
class Response<T> {

    /**
     * 返回编码
     */
    var code: Int? = 0

    /**
     * 返回消息
     */
    var message: String? = "ok"

    /**
     * 返回数据
     */
    var data: T? = null

}