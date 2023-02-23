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
    FILED;

    companion object {

        /**
         * 获取会议状态枚举
         */
        fun valueOf(ordinal: Int): MeetingStatus? {
            return values().find { it.ordinal == ordinal }
        }

    }

}