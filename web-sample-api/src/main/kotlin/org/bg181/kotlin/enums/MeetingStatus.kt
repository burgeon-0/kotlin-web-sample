package org.bg181.kotlin.enums

/**
 * 会议状态
 *
 * @author lxc
 * @date 2023/02/11
 */
enum class MeetingStatus {

    /**
     * 会议前
     */
    BEFORE,

    /**
     * 会议中
     */
    DURING,

    /**
     * 已结束
     */
    FINISH,

    /**
     * 已取消
     */
    CANCEL,

    /**
     * 已归档
     */
    FILED

}