/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 127.0.0.1:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 24/05/2020 17:46:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for api
-- ----------------------------
DROP TABLE IF EXISTS `api`;
CREATE TABLE `api`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api
-- ----------------------------
INSERT INTO `api` VALUES (1, 'viewGoods');
INSERT INTO `api` VALUES (2, 'addGoods');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标志',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `num` bigint(255) NULL DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '手机', -80);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `count` bigint(20) NULL DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (43, 1, 1);
INSERT INTO `order` VALUES (44, 1, 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '游客');

-- ----------------------------
-- Table structure for roleapi
-- ----------------------------
DROP TABLE IF EXISTS `roleapi`;
CREATE TABLE `roleapi`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(11) NULL DEFAULT NULL,
  `apiId` bigint(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roleapi
-- ----------------------------
INSERT INTO `roleapi` VALUES (1, 1, 1);
INSERT INTO `roleapi` VALUES (2, 1, 2);
INSERT INTO `roleapi` VALUES (3, 2, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `roleId` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$D0OvhHj2Lh92rNey1EFmM.OqltxhH1vZA8mDpxz7jEofDEqLRplQy', 1);
INSERT INTO `user` VALUES (2, 'guest', '$2a$10$D0OvhHj2Lh92rNey1EFmM.OqltxhH1vZA8mDpxz7jEofDEqLRplQy', 2);

SET FOREIGN_KEY_CHECKS = 1;
