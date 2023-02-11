package org.bg181.kotlin.support.common.extend

import org.slf4j.LoggerFactory

/**
 * 属性复制函数 - 基准测试
 *
 * @author lxc
 * @date 2023/02/10
 */
class FieldCopyExtensionBenchmarkTest

private val logger = LoggerFactory.getLogger(FieldCopyExtensionBenchmarkTest::class.java)

/**
 * 测试结果：
 * ====== start to org.bg181.kotlin.common.extend.run [1] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 1 times, cost 0 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 1 times, cost 0 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 1 times, cost 0 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 1 times, cost 0 ms.
 * ====== start to org.bg181.kotlin.common.extend.run [10] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 10 times, cost 0 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 10 times, cost 4 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 10 times, cost 0 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 10 times, cost 8 ms.
 * ====== start to org.bg181.kotlin.common.extend.run [100] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 100 times, cost 0 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 100 times, cost 24 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 100 times, cost 0 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 100 times, cost 10 ms.
 * ====== start to org.bg181.kotlin.common.extend.run [1000] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 1000 times, cost 0 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 1000 times, cost 74 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 1000 times, cost 0 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 1000 times, cost 26 ms.
 * ====== start to org.bg181.kotlin.common.extend.run [10000] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 10000 times, cost 0 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 10000 times, cost 147 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 10000 times, cost 0 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 10000 times, cost 23 ms.
 * ====== start to org.bg181.kotlin.common.extend.run [100000] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 100000 times, cost 2 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 100000 times, cost 177 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 100000 times, cost 2 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 100000 times, cost 177 ms.
 * ====== start to org.bg181.kotlin.common.extend.run [1000000] ======
 * Use apply function, org.bg181.kotlin.common.extend.run 1000000 times, cost 3 ms.
 * Use convert function, org.bg181.kotlin.common.extend.run 1000000 times, cost 1559 ms.
 * Use apply function, org.bg181.kotlin.common.extend.run 1000000 times, cost 2 ms.
 * Use fillBy function, org.bg181.kotlin.common.extend.run 1000000 times, cost 1214 ms.
 *
 * 测试结果分析（结果跟多种因素有关，如测试用例的选择、机器的性能等，目前只针对此次结果进行分析）：
 * 1. 如果使用的是 apply 函数，性能极好，运行 100万 次，耗时不过 2-3 毫秒。
 * 2. 如果使用的是自定义扩展函数，运行 1 次时，耗时忽略不计；运行 10 次时，耗时几毫秒；运行 100 次时，耗时 10-20 几毫秒；
 * 运行 1000 次时，耗时 20-70 几毫秒；运行 1-10万 次时，耗时 100-200 毫秒；运行 100万 次时，耗时 1 秒多。
 * 3. 对于数据量不大，性能要求不高的场景，可放心使用；对于数据量大，或者性能敏感的场景，不建议使用。
 *
 * 最终修正结论：建议使用 mapstruct，mapstruct 在编译期将 set 代码生成，运行期直接执行 set 方法，性能极好。
 */
fun main() {
    val notebook1 = Notebook("rrr-xxx", "测试1", "描述1")
    val notebook2 = Notebook("rrr-ccc", "测试2", "描述2")

    // 预热（文件/函数加载）
    convert2(notebook1)

    // 基准测试
    run(1, notebook1, notebook2)
    run(10, notebook1, notebook2)
    run(100, notebook1, notebook2)
    run(1000, notebook1, notebook2)
    run(10000, notebook1, notebook2)
    run(100000, notebook1, notebook2)
    run(1000000, notebook1, notebook2)
}

private fun run(total: Int, notebook1: Notebook, notebook2: Notebook) {
    println(" * ====== start to org.bg181.kotlin.common.extend.run [$total] ======")
    // test convert
    var time = System.currentTimeMillis()
    for (i in 1..total) {
        convert1(notebook1)
    }
    println(" * Use apply function, org.bg181.kotlin.common.extend.run $total times, cost ${System.currentTimeMillis() - time} ms.")
    time = System.currentTimeMillis()
    for (i in 1..total) {
        convert2(notebook1)
    }
    println(" * Use convert function, org.bg181.kotlin.common.extend.run $total times, cost ${System.currentTimeMillis() - time} ms.")

    // test fillBy
    time = System.currentTimeMillis()
    for (i in 1..total) {
        fillBy1(notebook1, notebook2)
    }
    println(" * Use apply function, org.bg181.kotlin.common.extend.run $total times, cost ${System.currentTimeMillis() - time} ms.")
    time = System.currentTimeMillis()
    for (i in 1..total) {
        fillBy2(notebook1, notebook2)
    }
    println(" * Use fillBy function, org.bg181.kotlin.common.extend.run $total times, cost ${System.currentTimeMillis() - time} ms.")
}

private fun convert1(notebook: Notebook): Notebook {
    return notebook.apply {
        this.uid = notebook.uid
        this.title = notebook.title
        this.description = notebook.description
    }
}

private fun convert2(notebook: Notebook): Notebook {
    return notebook.convert(Notebook::class.java)
}

private fun fillBy1(source: Notebook, target: Notebook): Notebook {
    return target.apply {
        this.uid = source.uid
        this.title = source.title
        this.description = source.description
    }
}

private fun fillBy2(source: Notebook, target: Notebook): Notebook {
    return target.fillBy(source)
}

data class Notebook(var uid: String?, var title: String?, var description: String?) {
    constructor() : this(null, null, null)
}