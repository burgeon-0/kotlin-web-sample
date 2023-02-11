package org.bg181.kotlin.support.common.extend

import org.springframework.beans.BeanUtils
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import java.beans.PropertyDescriptor

/**
 * <p>
 * 提供属性复制（field copy）函数，可以为我们带来便利，如下面的场景：
 * 1. 不使用属性复制函数时：
 * <pre>
 *     val notebookBo = NotebookBo().apply {
 *         uid = notebookPo.uid
 *         title = notebookPo.title
 *         description = notebookPo.description
 *         ......
 *     }
 * </pre>
 * 2. 使用属性复制函数时：
 * <pre>
 *     val notebookBo = notebookPo.convert(NotebookBo::class.java)
 * </pre>
 * </p>
 *
 * <p>
 * 提供属性复制（field copy）函数，面临着两个问题，一是安全性问题，二是性能问题。
 * 1. 安全性问题：对于目标对象的不可变[val]属性，属性复制会失效。为解决此问题，当目标对象存在不可变[val]属性时，函数将抛出异常。
 * （其核心问题在于，对于不可变[val]属性，复制不起作用，如果开发人员不清楚，将带来巨大的安全隐患。）
 * 2. 性能问题：[FieldCopyExtensionBenchmarkTest]
 * </p>
 */
class FieldCopyExtension

/**
 * 【扩展】对象转换函数
 *
 * @param clazz 指定需要转换成哪个类的对象
 * @param ignoreProperties 排除的属性
 * @return 转换后的对象
 */
fun <T : Any> Any.convert(clazz: Class<T>, vararg ignoreProperties: String): T {
    return this.convert(clazz, true, *ignoreProperties)
}

/**
 * 【扩展】对象转换函数
 *
 * @param clazz 指定需要转换成哪个类的对象
 * @param ignoreNullValue 排除空值
 * @param ignoreProperties 排除的属性
 * @return 转换后的对象
 */
fun <T : Any> Any.convert(clazz: Class<T>, ignoreNullValue: Boolean, vararg ignoreProperties: String): T {
    val obj = clazz.getDeclaredConstructor().newInstance()
    checkIfExistImmutableField(obj)
    var ignores = when (ignoreNullValue) {
        true -> getNullPropertyNames(this)
        else -> listOf<String>()
    }
    if (ignoreProperties.isNotEmpty()) {
        ignores = ignores.plus(ignoreProperties)
    }
    BeanUtils.copyProperties(this, obj, *ignores.toTypedArray())
    return obj
}

/**
 * 【扩展】对象填充函数
 *
 * @param source 数据来源对象
 * @param ignoreProperties 排除的属性
 * @return 对象本身
 */
fun <T : Any> T.fillBy(source: Any, vararg ignoreProperties: String): T {
    return this.fillBy(source, true, *ignoreProperties)
}

/**
 * 【扩展】对象填充函数
 *
 * @param source 数据来源对象
 * @param ignoreNullValue 排除空值
 * @param ignoreProperties 排除的属性
 * @return 对象本身
 */
fun <T : Any> T.fillBy(source: Any, ignoreNullValue: Boolean, vararg ignoreProperties: String): T {
    checkIfExistImmutableField(this)
    var ignores = when (ignoreNullValue) {
        true -> getNullPropertyNames(source)
        else -> listOf<String>()
    }
    if (ignoreProperties.isNotEmpty()) {
        ignores = ignores.plus(ignoreProperties)
    }
    BeanUtils.copyProperties(source, this, *ignores.toTypedArray())
    return this
}

/**
 * 检查是否存在不可变属性
 *
 * @param target
 */
private fun checkIfExistImmutableField(target: Any) {
    val className = target::class.java.name
    val tar: BeanWrapper = BeanWrapperImpl(target)
    val pds: Array<PropertyDescriptor> = tar.getPropertyDescriptors()
    pds.filter {
        it.name != "class" && tar.getPropertyDescriptor(it.name).writeMethod == null
    }.map {
        throw IllegalAccessException("${className} - 不可变属性(val ${it.name})的值不可变更!!!")
    }
}

/**
 * 获取值为空的属性
 *
 * @param source
 * @return
 */
private fun getNullPropertyNames(source: Any): List<String> {
    val src: BeanWrapper = BeanWrapperImpl(source)
    val pds: Array<PropertyDescriptor> = src.getPropertyDescriptors()
    return pds.filter {
        src.getPropertyValue(it.name) == null
    }.map {
        it.name
    }
}