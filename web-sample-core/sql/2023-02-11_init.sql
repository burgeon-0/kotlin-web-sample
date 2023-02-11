-- Create Database
CREATE DATABASE `kotlin_web_sample` DEFAULT CHARACTER SET utf8mb4;

-- Create Tables
CREATE TABLE IF NOT EXISTS `t_meeting` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `meeting_no` bigint(20) unsigned NOT NULL COMMENT '会议编号',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '会议主题',
  `content` varchar(200) NOT NULL DEFAULT '' COMMENT '会议内容',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '会议状态：0-会议前，1-会议中，2-已结束，3-已取消，4-已归档',
  `deleted` tinyint(1) NOT NULL COMMENT '逻辑删除：0-未删除，1-已删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `meeting_no_idx` (`meeting_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会议';