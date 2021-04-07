/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : electricity

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 07/04/2021 16:33:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for instrument_data_record
-- ----------------------------
DROP TABLE IF EXISTS `instrument_data_record`;
CREATE TABLE `instrument_data_record`  (
  `id` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `relay01` int(1) NULL DEFAULT NULL COMMENT '继电器1',
  `relay02` int(1) NULL DEFAULT NULL COMMENT '继电器2',
  `relay03` int(1) NULL DEFAULT NULL COMMENT '继电器3',
  `switch01` int(1) NULL DEFAULT NULL COMMENT '开关量01',
  `switch02` int(1) NULL DEFAULT NULL COMMENT '开关量02',
  `switch03` int(1) NULL DEFAULT NULL COMMENT '开关量03',
  `switch04` int(1) NULL DEFAULT NULL COMMENT '开关量04',
  `uab` decimal(32, 3) NULL DEFAULT NULL COMMENT 'ab线电压\r\n',
  `ubc` decimal(32, 3) NULL DEFAULT NULL COMMENT 'bc线电压\r\n',
  `uca` decimal(32, 3) NULL DEFAULT NULL COMMENT 'ca线电压\r\n',
  `ia` decimal(32, 3) NULL DEFAULT NULL COMMENT 'a相电流\r\n',
  `ib` decimal(32, 3) NULL DEFAULT NULL COMMENT 'b相电流\r\n',
  `ic` decimal(32, 3) NULL DEFAULT NULL COMMENT 'c相电流\r\n',
  `pa` decimal(32, 3) NULL DEFAULT NULL COMMENT 'a相有功功率\r\n',
  `pb` decimal(32, 3) NULL DEFAULT NULL COMMENT 'b相有功功率\r\n',
  `pc` decimal(32, 3) NULL DEFAULT NULL COMMENT 'c相有功功率\r\n',
  `p0` decimal(32, 3) NULL DEFAULT NULL COMMENT '总有功功率\r\n',
  `q0` decimal(32, 3) NULL DEFAULT NULL COMMENT '总无功功率\r\n',
  `rate` decimal(32, 3) NULL DEFAULT NULL COMMENT '总功率因数\r\n',
  `w0` decimal(32, 3) NULL DEFAULT NULL COMMENT '正向有功',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
