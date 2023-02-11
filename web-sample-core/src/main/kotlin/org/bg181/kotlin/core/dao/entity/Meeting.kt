package org.bg181.kotlin.core.dao.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.util.Date

/**
 * <p>
 * 会议
 * </p>
 * (本文件是自动生成的，请不要手动修改)
 *
 * @author lxc
 * @date 2023/02/11
 */
@TableName("t_meeting")
class Meeting : Serializable {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 会议编号
     */
    var meetingNo: Long? = null

    /**
     * 会议主题
     */
    var title: String? = null

    /**
     * 会议内容
     */
    var content: String? = null

    /**
     * 开始时间
     */
    var startTime: Date? = null

    /**
     * 结束时间
     */
    var endTime: Date? = null

    /**
     * 会议状态：0-会议前，1-会议中，2-已结束，3-已取消，4-已归档
     */
    var status: Byte? = null

    /**
     * 逻辑删除：0-未删除，1-已删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    var deleted: Boolean? = null

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    var createTime: Date? = null

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: Date? = null

    override fun toString(): String {
        return "Meeting{" +
        "id=" + id +
        ", meetingNo=" + meetingNo +
        ", title=" + title +
        ", content=" + content +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        ", deleted=" + deleted +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}"
    }
}
