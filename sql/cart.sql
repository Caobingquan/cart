/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : cart

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-01-16 17:39:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `C_U_ID` int(11) NOT NULL COMMENT '购物车对应的用户id',
  `C_P_ID` int(11) DEFAULT NULL COMMENT '购物车中的商品id',
  `C_AMOUNT` int(10) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`C_ID`),
  KEY `C_U_ID` (`C_U_ID`),
  KEY `C_P_ID` (`C_P_ID`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`C_U_ID`) REFERENCES `user` (`U_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`C_P_ID`) REFERENCES `product` (`P_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('7', '1', '3', '8');
INSERT INTO `cart` VALUES ('10', '1', '5', '1');
INSERT INTO `cart` VALUES ('15', '1', '8', '1');
INSERT INTO `cart` VALUES ('16', '1', '2', '1');
INSERT INTO `cart` VALUES ('24', '3', '2', '2');
INSERT INTO `cart` VALUES ('30', '2', '1', '2');
INSERT INTO `cart` VALUES ('31', '2', '4', '4');
INSERT INTO `cart` VALUES ('32', '2', '8', '1');
INSERT INTO `cart` VALUES ('33', '1', '18', '1');
INSERT INTO `cart` VALUES ('34', '3', '18', '2');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `P_ID` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `P_NAME` varchar(20) NOT NULL COMMENT '商品标题',
  `P_PRICE` int(10) DEFAULT NULL COMMENT '商品价格',
  `P_INVENTORY` int(10) DEFAULT NULL COMMENT '商品库存',
  `P_PICTURE` varchar(32) DEFAULT NULL COMMENT '商品图片',
  `P_STATUS` int(1) DEFAULT '0' COMMENT '商品状态(1锁定0未锁定)',
  `P_DETAILS` varchar(50) DEFAULT NULL COMMENT '商品详情',
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '小米6', '100', '456', 'liebiao_xiaomi6.jpg', '0', '5.16早10点开售');
INSERT INTO `product` VALUES ('2', '小米手机5c', '1499', '275', 'liebiao_xiaomi5c.jpg', '0', '搭载澎湃S1 八核高性能处理器');
INSERT INTO `product` VALUES ('3', '小米Note 2', '799', '3', 'liebiao_xiaomint2.jpg', '0', '5月9日-20日 小米Note 2 享花呗12期分期免息');
INSERT INTO `product` VALUES ('4', '小米MIX', '499', '4567', 'liebiao_xiaomimix.jpg', '0', '5月9日-20日小米MIX 享花呗12期分期免息');
INSERT INTO `product` VALUES ('5', '小米5s', '1999', '53', 'liebiao_xiaomi5s.jpg', '0', '“暗夜之眼”超感光相机 / 无孔式超声波');
INSERT INTO `product` VALUES ('6', '小米手机5', '1799', '67', 'liebiao_xiaomi5.jpg', '0', '骁龙820处理器 / UFS 2.0 闪存');
INSERT INTO `product` VALUES ('7', '红米Note 4', '1399', '78', 'liebiao_hongmin4.jpg', '0', '十核旗舰处理器 / 全金属一体化机身');
INSERT INTO `product` VALUES ('8', '小米手机5 64GB', '1799', '88', 'pinpai3.png', '0', '5月9日-10日，下单立减100元');
INSERT INTO `product` VALUES ('9', '红米4', '999', '95', 'liebiao_hongmin42.jpg', '0', '2.5D 玻璃，金属一体化机身');
INSERT INTO `product` VALUES ('10', '红米Note 4X 全网通版', '1299', '108', 'liebiao_hongmin4x.jpg', '0', '多彩金属 / 4100mAh 超长续航');
INSERT INTO `product` VALUES ('11', '1', '2323', '34', 'liebiao_xiaomimix.jpg', '0', '发斯蒂芬');
INSERT INTO `product` VALUES ('12', '华为1', '455', '467', 'liebiao_xiaomimix.jpg', '0', '风格还是');
INSERT INTO `product` VALUES ('13', '华为2', '646', '33', 'liebiao_xiaomimix.jpg', '0', ' 个');
INSERT INTO `product` VALUES ('14', '华为3', '467', '77', 'liebiao_xiaomimix.jpg', '0', '是个');
INSERT INTO `product` VALUES ('15', '华为4', '3', '555', 'liebiao_xiaomimix.jpg', '0', ' 是个');
INSERT INTO `product` VALUES ('16', '华为5', '76', '67', 'liebiao_xiaomimix.jpg', '0', '是');
INSERT INTO `product` VALUES ('17', '华为6', '67', '3456', 'liebiao_xiaomimix.jpg', '0', '是');
INSERT INTO `product` VALUES ('18', '罪', '0', '10000', 'zui.jpg', '0', '买罪受');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `U_ID` int(4) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `U_NAME` varchar(12) NOT NULL COMMENT '用户名',
  `U_PASSWORD` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `U_SEX` int(1) DEFAULT '1' COMMENT '用户性别（1为男，0为女）',
  `U_PHOTO` varchar(32) DEFAULT '1.jpg' COMMENT '用户头像',
  `U_PHONE` varchar(11) DEFAULT NULL COMMENT '用户电话',
  `U_ADDRESS` varchar(50) DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`U_ID`),
  UNIQUE KEY `U_NAME` (`U_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', 'user', '1', '1.jpg', '11111111111', 'a');
INSERT INTO `user` VALUES ('2', 'aa', 'aa', '1', '1.jpg', '22222222222', 'b');
INSERT INTO `user` VALUES ('3', 'ddd', 'ddd', '1', '1.jpg', '13222222222', null);
INSERT INTO `user` VALUES ('4', 'aaa', 'aaa', '1', '1.jpg', '13222222242', null);
INSERT INTO `user` VALUES ('5', 'bb', 'bb', '1', '1.jpg', '11111111112', null);
INSERT INTO `user` VALUES ('6', 'ee', 'ee', '1', '1.jpg', '13222222222', null);
