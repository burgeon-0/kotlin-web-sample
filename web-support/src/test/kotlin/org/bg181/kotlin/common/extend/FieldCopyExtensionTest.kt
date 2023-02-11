package org.bg181.kotlin.common.extend

import org.junit.Assert.assertThrows
import org.junit.Test
import org.slf4j.LoggerFactory
import java.io.Serializable

/**
 * 扩展函数影响范围较广，如果修改了 FieldCopyExtension，一定要跑一下单元测试，测试通过才可以发布代码
 *
 * @author lxc
 * @date 2023/02/10
 */
class FieldCopyExtensionTest {

    private val logger = LoggerFactory.getLogger(FieldCopyExtensionTest::class.java)

    @Test
    fun test() {
        logger.info("====== normal test ======")
        normalTest()
        logger.info("====== null value test ======")
        nullValueTest()
        logger.info("====== override null value test ======")
        overrideNullValueTest()
    }

    /**
     * 常规功能测试
     */
    private fun normalTest() {
        // 测试 fillBy 函数，和 ignoreProperties 参数
        val person = Person("sam", 3)
        val student = Student("lily", 12)
        // Person to Student
        student.fillBy(person, "name")
        logger.info("person: $person")
        assert(person.name == "sam" && person.age == 3)
        logger.info("student: $student")
        assert(student.name == "lily" && student.age == 3)
        student.fillBy(person)
        logger.info("student: $student")
        assert(student.name == "sam" && student.age == 3)
        // Student to Student
        student.fillBy(Student("lucy", 21))
        logger.info("student: $student")
        assert(student.name == "lucy" && student.age == 21)

        // 测试 convert 函数，和 ignoreProperties 参数
        // Person to Student
        val student2 = person.convert(Student::class.java)
        logger.info("student2: $student2")
        assert(student2.name == "sam" && student2.age == 3)
        val student3 = person.convert(Student::class.java, "name")
        logger.info("student3: $student3")
        assert(student3.name == null && student3.age == 3)
        // Student to Student
        val student4 = student.convert(Student::class.java)
        logger.info("student4: $student4")
        assert(student4.name == "lucy" && student4.age == 21)
        val student5 = student.convert(Student::class.java, "age")
        logger.info("student5: $student5")
        assert(student5.name == "lucy" && student5.age == null)

        // Teacher 含有 val 属性，会抛出异常
        assertThrows<IllegalAccessException>(IllegalAccessException::class.java, {
            val teacher = person.convert(Teacher::class.java)
            logger.info("teacher: $teacher")
        })
        // Teacher 含有 val 属性，会抛出异常
        assertThrows<IllegalAccessException>(IllegalAccessException::class.java, {
            val teacher2 = Teacher()
            logger.info("teacher2: $teacher2")
            teacher2.fillBy(person)
            logger.info("teacher2: $teacher2")
        })
    }

    /**
     * 空值测试
     */
    private fun nullValueTest() {
        // 测试 fillBy 函数，和 ignoreProperties 参数
        val person = Person(null, 3)
        val student = Student("lily", 12)
        // Person to Student
        student.fillBy(person, "age")
        logger.info("person: $person")
        assert(person.name == null && person.age == 3)
        logger.info("student: $student")
        assert(student.name == "lily" && student.age == 12)
        student.fillBy(person)
        logger.info("student: $student")
        assert(student.name == "lily" && student.age == 3)
        // Student to Student
        student.fillBy(Student("lucy", null))
        logger.info("student: $student")
        assert(student.name == "lucy" && student.age == 3)
    }

    /**
     * 空值覆盖测试
     */
    private fun overrideNullValueTest() {
        // 测试 fillBy 函数，和 ignoreProperties 参数
        val person = Person(null, 3)
        val student = Student("lily", 12)
        // Person to Student
        student.fillBy(person, false, "age")
        logger.info("person: $person")
        assert(person.name == null && person.age == 3)
        logger.info("student: $student")
        assert(student.name == null && student.age == 12)
        student.fillBy(person, false)
        logger.info("student: $student")
        assert(student.name == null && student.age == 3)
        // Student to Student
        student.fillBy(Student("lucy", null), false)
        logger.info("student: $student")
        assert(student.name == "lucy" && student.age == null)
    }

    /**
     * TODO 疑问：为何这里的 data class 一定要有无参构造函数，独立项目中的 data class 没有无参构造函数也可以跑成功？
     */
    data class Person(var name: String?, var age: Int?) : Serializable {
        constructor() : this(null, null)
    }

    data class Student(var name: String?, var age: Int?) : Serializable {
        constructor() : this(null, null)
    }

    data class Teacher(val name: String?, val age: Int?) : Serializable {
        constructor() : this(null, null)
    }

}