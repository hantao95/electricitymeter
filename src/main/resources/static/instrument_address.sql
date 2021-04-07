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

 Date: 07/04/2021 16:32:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for instrument_address
-- ----------------------------
DROP TABLE IF EXISTS `instrument_address`;
CREATE TABLE `instrument_address`  (
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `type` int(11) NOT NULL COMMENT '仪表类型',
  `address_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '线路名称',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`address`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '线路信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
