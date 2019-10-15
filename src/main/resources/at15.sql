/*
Navicat MySQL Data Transfer

Source Server         : 47.98.225.144
Source Server Version : 50727
Source Host           : 47.98.225.144:3306
Source Database       : at15

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-10-15 11:03:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dailysummaryfeedrest
-- ----------------------------
DROP TABLE IF EXISTS `t_dailysummaryfeedrest`;
CREATE TABLE `t_dailysummaryfeedrest` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `productivity_pulse` decimal(10,0) DEFAULT NULL,
  `veryProductive_percentage` decimal(10,0) DEFAULT NULL,
  `productive_percentage` decimal(10,0) DEFAULT NULL,
  `neutral_percentage` decimal(10,0) DEFAULT NULL,
  `distracting_percentage` decimal(10,0) DEFAULT NULL,
  `veryDistracting_percentage` decimal(10,0) DEFAULT NULL,
  `allProductive_percentage` decimal(10,0) DEFAULT NULL,
  `allDistracting_percentage` decimal(10,0) DEFAULT NULL,
  `uncategorized_percentage` decimal(10,0) DEFAULT NULL,
  `business_percentage` decimal(10,0) DEFAULT NULL,
  `communicationAndScheduling_percentage` decimal(10,0) DEFAULT NULL,
  `socialNetworking_percentage` decimal(10,0) DEFAULT NULL,
  `designAndComposition_percentage` decimal(10,0) DEFAULT NULL,
  `entertainment_percentage` decimal(10,0) DEFAULT NULL,
  `news_percentage` decimal(10,0) DEFAULT NULL,
  `softwareDevelopment_percentage` decimal(10,0) DEFAULT NULL,
  `referenceAndLearning_percentage` decimal(10,0) DEFAULT NULL,
  `shopping_percentage` decimal(10,0) DEFAULT NULL,
  `utilities_percentage` decimal(10,0) DEFAULT NULL,
  `total_hours` decimal(10,0) DEFAULT NULL,
  `veryProductive_hours` decimal(10,0) DEFAULT NULL,
  `productive_hours` decimal(10,0) DEFAULT NULL,
  `neutral_hours` decimal(10,0) DEFAULT NULL,
  `distracting_hours` decimal(10,0) DEFAULT NULL,
  `veryDistracting_hours` decimal(10,0) DEFAULT NULL,
  `allProductive_hours` decimal(10,0) DEFAULT NULL,
  `allDistracting_hours` decimal(10,0) DEFAULT NULL,
  `uncategorized_hours` decimal(10,0) DEFAULT NULL,
  `business_hours` decimal(10,0) DEFAULT NULL,
  `communicationAndScheduling_hours` decimal(10,0) DEFAULT NULL,
  `socialNetworking_hours` decimal(10,0) DEFAULT NULL,
  `designAndComposition_hours` decimal(10,0) DEFAULT NULL,
  `entertainment_hours` decimal(10,0) DEFAULT NULL,
  `news_hours` decimal(10,0) DEFAULT NULL,
  `softwareDevelopment_hours` decimal(10,0) DEFAULT NULL,
  `referenceAndLearning_hours` decimal(10,0) DEFAULT NULL,
  `shopping_hours` decimal(10,0) DEFAULT NULL,
  `utilities_hours` decimal(10,0) DEFAULT NULL,
  `totalDuration_formatted` varchar(255) DEFAULT NULL,
  `veryProductiveDuration_formatted` varchar(255) DEFAULT NULL,
  `productiveDuration_formatted` varchar(255) DEFAULT NULL,
  `neutralDuration_formatted` varchar(255) DEFAULT NULL,
  `distractingDuration_formatted` varchar(255) DEFAULT NULL,
  `veryDistractingDuration_formatted` varchar(255) DEFAULT NULL,
  `allProductiveDuration_formatted` varchar(255) DEFAULT NULL,
  `allDistractingDuration_formatted` varchar(255) DEFAULT NULL,
  `uncategorizedDuration_formatted` varchar(255) DEFAULT NULL,
  `businessDuration_formatted` varchar(255) DEFAULT NULL,
  `communicationAndSchedulingDuration_formatted` varchar(255) DEFAULT NULL,
  `socialNetworkingDuration_formatted` varchar(255) DEFAULT NULL,
  `designAndCompositionDuration_formatted` varchar(255) DEFAULT NULL,
  `entertainmentDuration_formatted` varchar(255) DEFAULT NULL,
  `newsDuration_formatted` varchar(255) DEFAULT NULL,
  `softwareDevelopmentDuration_formatted` varchar(255) DEFAULT NULL,
  `referenceAndLearningDuration_formatted` varchar(255) DEFAULT NULL,
  `shoppingDuration_formatted` varchar(255) DEFAULT NULL,
  `utilitiesDuration_formatted` varchar(255) DEFAULT NULL,
  `id` int(30) DEFAULT NULL,
  `year` int(10) DEFAULT NULL,
  `month` int(10) DEFAULT NULL,
  `day` int(10) DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_heart
-- ----------------------------
DROP TABLE IF EXISTS `t_heart`;
CREATE TABLE `t_heart` (
  `pro_user_id` int(11) NOT NULL,
  `branch` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `category` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `created_at` datetime DEFAULT NULL,
  `cursorpos` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `dependencies` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `id` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `is_write` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `language` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `lineno` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `lines` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `machine_name_id` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `project` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `time` decimal(10,0) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `user_agent_id` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `user_id` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `entity` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `day` varchar(30) COLLATE utf8mb4_bin DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_history_seven
-- ----------------------------
DROP TABLE IF EXISTS `t_history_seven`;
CREATE TABLE `t_history_seven` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `digital` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `minutes` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_seconds` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_stinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_stinfo`;
CREATE TABLE `t_stinfo` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sum_duration` decimal(30,0) DEFAULT NULL,
  `sum_distance` decimal(30,0) DEFAULT NULL,
  `sum_elevation_gain` decimal(30,0) DEFAULT NULL,
  `count_distance` decimal(30,0) DEFAULT NULL,
  `sum_credits` decimal(30,0) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_summary_cate
-- ----------------------------
DROP TABLE IF EXISTS `t_summary_cate`;
CREATE TABLE `t_summary_cate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `day` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `digital` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `hours` bigint(255) DEFAULT NULL,
  `minutes` bigint(255) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `percent` bigint(255) DEFAULT NULL,
  `seconds` bigint(255) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_seconds` decimal(30,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `api_day_id` (`id`,`api_key`,`day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_summary_depend
-- ----------------------------
DROP TABLE IF EXISTS `t_summary_depend`;
CREATE TABLE `t_summary_depend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `day` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `digital` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `hours` bigint(255) DEFAULT NULL,
  `minutes` bigint(255) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `percent` bigint(255) DEFAULT NULL,
  `seconds` bigint(255) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_seconds` decimal(30,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `api_day_id` (`id`,`api_key`,`day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=918 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_summary_editor
-- ----------------------------
DROP TABLE IF EXISTS `t_summary_editor`;
CREATE TABLE `t_summary_editor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `day` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `digital` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `hours` bigint(255) DEFAULT NULL,
  `minutes` bigint(255) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `percent` bigint(255) DEFAULT NULL,
  `seconds` bigint(255) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_seconds` decimal(30,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `api_day_id` (`id`,`api_key`,`day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_summary_language
-- ----------------------------
DROP TABLE IF EXISTS `t_summary_language`;
CREATE TABLE `t_summary_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `day` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `digital` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `hours` bigint(255) DEFAULT NULL,
  `minutes` bigint(255) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `percent` bigint(255) DEFAULT NULL,
  `seconds` bigint(255) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_seconds` decimal(30,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `api_day_id` (`id`,`api_key`,`day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_summary_project
-- ----------------------------
DROP TABLE IF EXISTS `t_summary_project`;
CREATE TABLE `t_summary_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `day` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `digital` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `hours` bigint(255) DEFAULT NULL,
  `minutes` bigint(255) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `percent` bigint(255) DEFAULT NULL,
  `seconds` bigint(255) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_seconds` decimal(30,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `api_day_id` (`id`,`api_key`,`day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_user_api
-- ----------------------------
DROP TABLE IF EXISTS `t_user_api`;
CREATE TABLE `t_user_api` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_user_durations
-- ----------------------------
DROP TABLE IF EXISTS `t_user_durations`;
CREATE TABLE `t_user_durations` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `cursorpos` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `duration` decimal(10,0) DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `lineno` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `machine_name_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `project` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `time` decimal(10,0) DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `day` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2360 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_user_project
-- ----------------------------
DROP TABLE IF EXISTS `t_user_project`;
CREATE TABLE `t_user_project` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `html_escaped_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `repository` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_waka_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_waka_userinfo`;
CREATE TABLE `t_waka_userinfo` (
  `api_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `created_at` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `display_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `email_public` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `has_premium_features` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `human_readable_website` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `is_email_confirmed` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `is_hireable` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `languages_used_public` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `last_heartbeat_at` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `last_plugin` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `last_plugin_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `last_project` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `location` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `logged_time_public` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `modified_at` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `needs_payment_method` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `photo_public` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `plan` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `timezone` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `website` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_woinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_woinfo`;
CREATE TABLE `t_woinfo` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `heart_source` decimal(30,0) DEFAULT NULL,
  `like_count` decimal(30,0) DEFAULT NULL,
  `duration` decimal(30,0) DEFAULT NULL,
  `sport` decimal(30,0) DEFAULT NULL,
  `id` decimal(30,0) DEFAULT NULL COMMENT '行车记录id',
  `upload_time` datetime DEFAULT NULL,
  `user_id` int(30) DEFAULT NULL,
  `uuid` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `cadence_source` decimal(30,0) DEFAULT NULL,
  `is_valid` decimal(30,0) DEFAULT NULL,
  `comment_count` decimal(30,0) DEFAULT NULL,
  `elevation_loss` decimal(30,0) DEFAULT NULL,
  `hidden` tinyint(5) DEFAULT NULL,
  `desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `threed_workout` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `map_id` int(30) DEFAULT NULL,
  `elevation_gain` decimal(30,0) DEFAULT NULL,
  `start_time` bigint(30) DEFAULT NULL,
  `credits` decimal(30,0) DEFAULT NULL,
  `is_segment` decimal(30,0) DEFAULT NULL,
  `is_like` decimal(30,0) DEFAULT NULL,
  `distance` decimal(30,0) DEFAULT NULL,
  `calories` decimal(30,0) DEFAULT NULL,
  `loc_source` decimal(30,0) DEFAULT NULL,
  `map_hidden` decimal(30,0) DEFAULT NULL,
  `end_time` bigint(30) DEFAULT NULL,
  `avg_speed` decimal(30,3) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for t_xz
-- ----------------------------
DROP TABLE IF EXISTS `t_xz`;
CREATE TABLE `t_xz` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `city_id` int(30) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `page` int(10) DEFAULT NULL,
  `user_id` int(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129861 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Procedure structure for person_add_int
-- ----------------------------
DROP PROCEDURE IF EXISTS `person_add_int`;
DELIMITER ;;
CREATE DEFINER=`huifer`@`%` PROCEDURE `person_add_int`()
BEGIN
	DECLARE
		i INT DEFAULT 1;
	WHILE
			i <= 100000 DO
			INSERT INTO t_test_limit
		VALUES
			( 0, uuid( ), 1, uuid( ) );
		
		SET i = i + 1;
		
	END WHILE;

END
;;
DELIMITER ;
