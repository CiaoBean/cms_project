/*
Navicat MySQL Data Transfer

Source Server         : 119.29.177.249(3309)
Source Server Version : 50729
Source Host           : 119.29.177.249:3309
Source Database       : testdemo

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-04-30 13:04:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for medicine_purchase_record
-- ----------------------------
DROP TABLE IF EXISTS `medicine_purchase_record`;
CREATE TABLE `medicine_purchase_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(50) NOT NULL COMMENT '名称',
  `manufacturer` varchar(50) NOT NULL COMMENT '厂商',
  `begin_price` double(8,2) DEFAULT NULL COMMENT '进价',
  `begin_date` datetime DEFAULT NULL COMMENT '生产日期',
  `end_date` datetime DEFAULT NULL COMMENT '有效日期',
  `batch_number` varchar(50) DEFAULT NULL COMMENT '批号',
  `number` int(10) DEFAULT NULL COMMENT '进货量',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位',
  `specifications` varchar(50) DEFAULT NULL COMMENT '规格',
  `purchase_time` datetime DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='进货记录';

-- ----------------------------
-- Records of medicine_purchase_record
-- ----------------------------
INSERT INTO `medicine_purchase_record` VALUES ('3', '(特普宁)头孢克肟颗粒', '成都倍特药业有限公司', '1.22', '2020-04-28 00:00:00', '2020-04-30 00:00:00', '171170', '5', '盒', '50mg*6袋', '2020-04-28 17:00:47');
INSERT INTO `medicine_purchase_record` VALUES ('8', '(特普宁)头孢克肟颗粒', '成都倍特药业有限公司', '2.00', '2020-04-28 00:00:00', '2020-04-30 00:00:00', '171170', '80', '盒', '50mg*6袋', '2020-04-28 18:03:27');
INSERT INTO `medicine_purchase_record` VALUES ('9', '(特普宁)头孢克肟颗粒', '成都倍特药业有限公司', '9.00', '2020-04-28 00:00:00', '2020-04-30 00:00:00', '171170', '5', '盒', '50mg*6袋', '2020-04-29 23:41:56');

-- ----------------------------
-- Table structure for medicine_purchase_records_1
-- ----------------------------
DROP TABLE IF EXISTS `medicine_purchase_records_1`;
CREATE TABLE `medicine_purchase_records_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_name` varchar(50) DEFAULT NULL,
  `manufacturer` varchar(50) DEFAULT NULL,
  `begin_price` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `sum` varchar(50) DEFAULT NULL,
  `begindate` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `pihao` varchar(50) DEFAULT NULL,
  `beizhu` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `guige` varchar(50) DEFAULT NULL,
  `tiaoxingma` varchar(50) DEFAULT NULL,
  `jinhuo_time` varchar(100) DEFAULT NULL,
  `gonghuoshang` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进货记录';

-- ----------------------------
-- Records of medicine_purchase_records_1
-- ----------------------------

-- ----------------------------
-- Table structure for medicine_sell_records
-- ----------------------------
DROP TABLE IF EXISTS `medicine_sell_records`;
CREATE TABLE `medicine_sell_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drugname` varchar(100) DEFAULT NULL,
  `changshang` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `pihao` varchar(100) DEFAULT NULL,
  `beizhu` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `guige` varchar(100) DEFAULT NULL,
  `amount` varchar(100) DEFAULT NULL,
  `sum` varchar(100) DEFAULT NULL,
  `selltime` varchar(100) DEFAULT NULL,
  `goumairen` varchar(100) DEFAULT NULL,
  `mobilephone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售历史记录表';

-- ----------------------------
-- Records of medicine_sell_records
-- ----------------------------

-- ----------------------------
-- Table structure for medicine_store
-- ----------------------------
DROP TABLE IF EXISTS `medicine_store`;
CREATE TABLE `medicine_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(50) NOT NULL COMMENT '名称',
  `manufacturer` varchar(50) NOT NULL COMMENT '厂商',
  `price` double(8,2) DEFAULT NULL COMMENT ' 销售价格',
  `begin_date` datetime DEFAULT NULL COMMENT '生产日期',
  `end_date` datetime DEFAULT NULL COMMENT '有效日期',
  `batch_number` varchar(50) DEFAULT NULL COMMENT '批号',
  `location` varchar(100) DEFAULT NULL COMMENT '存放地址',
  `count` int(10) DEFAULT NULL COMMENT '库存',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位',
  `specifications` varchar(50) DEFAULT NULL COMMENT '规格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='药品存储';

-- ----------------------------
-- Records of medicine_store
-- ----------------------------
INSERT INTO `medicine_store` VALUES ('1', '(特普宁)头孢克肟颗粒', '成都倍特药业有限公司', '8.00', '2020-04-28 00:00:00', '2020-04-30 00:00:00', '171170', 'A4第三层左', '158', '盒', '50mg*6袋', '处方药');

-- ----------------------------
-- Table structure for medicine_store_1
-- ----------------------------
DROP TABLE IF EXISTS `medicine_store_1`;
CREATE TABLE `medicine_store_1` (
  `drug_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '名称',
  `manufacturer` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '厂商',
  `begin_price` double(8,2) DEFAULT NULL COMMENT '进价',
  `price` varchar(8) CHARACTER SET utf8 DEFAULT NULL COMMENT ' 销售价格',
  `begin_date` datetime DEFAULT NULL COMMENT '生产日期',
  `end_date` datetime DEFAULT NULL COMMENT '有效日期',
  `batch_number` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '批号',
  `remark` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `location` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '存放地址',
  `count` int(10) DEFAULT NULL COMMENT '库存',
  `unit` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '单位',
  `specifications` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '规格',
  `bar_code` text CHARACTER SET utf8 COMMENT '条形码',
  PRIMARY KEY (`drug_name`,`manufacturer`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='药品存储';

-- ----------------------------
-- Records of medicine_store_1
-- ----------------------------
INSERT INTO `medicine_store_1` VALUES ('(特普宁)头孢克肟颗粒', '成都倍特药业有限公司', '5.80', '8.0', '2020-04-28 00:00:00', '2020-04-30 00:00:00', '171170', '处方药', 'A4第三层左', '45', '盒', '50mg*6袋', '111111');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2003 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '2', '/system/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '个人中心', '1', '1', 'system/user/profile', '', 'C', '0', '', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('2000', '药品管理', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-leaf', 'admin', '2020-04-28 14:26:46', '', null, '');
INSERT INTO `sys_menu` VALUES ('2001', '药品库存', '2000', '1', 'medicine/store/', 'menuItem', 'C', '0', null, 'fa fa-ship', 'admin', '2020-04-28 14:27:49', '', null, '');
INSERT INTO `sys_menu` VALUES ('2002', '进货记录', '2000', '2', 'medicine/record', 'menuItem', 'C', '0', null, 'fa fa-handshake-o', 'admin', '2020-04-28 15:55:01', '', null, '');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) DEFAULT '' COMMENT '用户昵称',
  `user_type` varchar(12) DEFAULT '',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', '若依', '管理员', 'haha@163.com', '15888888887', '男', '', '123456', 'f816c6', '1', '0', '127.0.0.1', '2020-04-28 23:41:33', 'admin', '2018-03-16 11:33:00', 'ry', '2020-04-30 12:48:47', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', 'ry', '若依', '普通用户', 'ry@qq.com', '15666666666', '女', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '2', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '测试员');
INSERT INTO `sys_user` VALUES ('100', null, 'caoxc', 'caoxc', '普通用户', '15622222222@qq.com', '15622222222', '男', '', '123456', '', '1', '2', '', null, '', '2020-04-29 00:53:37', '', '2020-04-29 23:23:38', '');
INSERT INTO `sys_user` VALUES ('101', null, 'admin11', 'admin11', '普通用户', '1042634581@qq.com', '15888888812', '女', '', '123456', '', '1', '0', '', null, '', '2020-04-29 13:01:34', '', null, 'asdf');
INSERT INTO `sys_user` VALUES ('102', null, 'admin22', 'admin22', '普通用户', '10426345381@qq.com', '15888888883', '女', '/profile/avatar/2020/04/29/3a4f7a51739575ad1beac0c151605778.png', '123456', '', '1', '0', '', null, '', '2020-04-29 13:11:50', '', '2020-04-29 21:04:43', 'saadmin22');
