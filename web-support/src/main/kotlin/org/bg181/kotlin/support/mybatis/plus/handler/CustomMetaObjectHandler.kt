package org.bg181.kotlin.support.mybatis.plus.handler

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import java.util.*

/**
 * 数据库字段自动填充
 *
 * @author lxc
 * @date 2023/02/11
 */
class CustomMetaObjectHandler : MetaObjectHandler {

    private val FIELD_DELETED = "deleted"
    private val FIELD_CREATE_TIME = "createTime"
    private val FIELD_UPDATE_TIME = "updateTime"

    override fun insertFill(metaObject: MetaObject?) {
        super.setFieldValByName(FIELD_DELETED, false, metaObject)
        super.setFieldValByName(FIELD_CREATE_TIME, Date(), metaObject)
        super.setFieldValByName(FIELD_UPDATE_TIME, Date(), metaObject)
    }

    override fun updateFill(metaObject: MetaObject?) {
        super.setFieldValByName(FIELD_UPDATE_TIME, Date(), metaObject)
    }

}