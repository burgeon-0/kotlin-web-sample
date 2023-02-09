package org.bg181.kotlin.common

import org.springframework.beans.BeanUtils

/**
 * @author lxc
 * @date 2023/02/09
 */

/**
 * 对象转换
 */
fun <T> Any.convertTo(clazz: Class<T>): T {
    var newObj = clazz.getDeclaredConstructor().newInstance()
    BeanUtils.copyProperties(this, newObj)
    return newObj
}