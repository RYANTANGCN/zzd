/*
 Navicat Premium Data Transfer

 Source Server         : 116.62.138.224_3306
 Source Server Type    : MariaDB
 Source Server Version : 100310
 Source Host           : 116.62.138.224:3306
 Source Schema         : paint

 Target Server Type    : MariaDB
 Target Server Version : 100310
 File Encoding         : 65001

 Date: 05/03/2020 16:18:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pm_fault_query
-- ----------------------------
DROP TABLE IF EXISTS `pm_fault_query`;
CREATE TABLE `pm_fault_query` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(255) DEFAULT NULL COMMENT '序号',
  `car_brand` varchar(255) DEFAULT NULL COMMENT '车品牌',
  `car_type` varchar(255) DEFAULT NULL COMMENT '车类型',
  `car_model` varchar(255) DEFAULT NULL COMMENT '车型',
  `fault_no` varchar(255) DEFAULT NULL COMMENT '故障编码',
  `fault_name` varchar(255) DEFAULT NULL COMMENT '故障名称',
  `fault_describe` varchar(255) DEFAULT NULL COMMENT '故障描述',
  `code_describe` varchar(255) DEFAULT NULL COMMENT '代码描述',
  `fault_eliminate` varchar(255) DEFAULT NULL COMMENT '消除故障步骤',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pm_fault_query
-- ----------------------------
BEGIN;
INSERT INTO `pm_fault_query` VALUES (1, '1', 'HYSTER', 'E', 'A401/A402', '112', '控制器电流过载', '电机外部U,V 或W连接短路；电机参数不匹配；控制器故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (2, '2', 'HYSTER', 'E', 'A401/A402', '113', '电流传感器故障', '电机 U、V、W通过定子对车体短路，导致漏电；控制器故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (3, '3', 'HYSTER', 'E', 'A401/A402', '114', '预充电失败', '电容器正端外接负载，使得电容器不能正常充电', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (4, '4', 'HYSTER', 'E', 'A401/A402', '115', '控制器温度低于-40摄氏度', '控制器工作环境过于严酷', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (5, '5', 'HYSTER', 'E', 'A401/A402', '116', '控制器温度过高', '控制器工作环境过于严酷；车辆超载；控制器安装错误', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (6, '6', 'HYSTER', 'E', 'A401/A402', '117', '电压过低，低于25.6V', '电池参数设置错误；非控制器系统耗电；电池阻抗过大；电池连接断开；熔断器断\n开，或主接触器未连接', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (7, '7', 'HYSTER', 'E', 'A401/A402', '118', '电压过高，超过70V', '电池参数设置错误；电池阻抗过高；再生制动时电池；连接断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (8, '8', 'HYSTER', 'E', 'A401/A402', '122', '控制器温度过高导致性能消减', '控制器工作环境严酷；车辆超载；控制器安装不正确。超过85摄氏度', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (9, '9', 'HYSTER', 'E', 'A401/A402', '123', '电压过低性能消减，电容低于', '电池电量不足；电池参数设置错误；非控制器系统耗尽电量；电池阻抗过大；电池连接断开；熔断器断开或主接触器断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (10, '10', 'HYSTER', 'E', 'A401/A402', '124', '电压过高性能消减', '再生制动过程中再生制动电流导致电池电压升高；电池参数设置错误；电池阻抗过大；再生制动时电池连接断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (11, '11', 'HYSTER', 'E', 'A401/A402', '125', '控制器输出5V电源失效', '外接负载阻抗过低，电压超出正负10%的误差超过96毫秒', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (12, '12', 'HYSTER', 'E', 'A401/A402', '128', '电机过热导致性能消减', '电机温度达到或者高于程序设定的160度，导致电流输出降低；电机温度参数设定有误', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (13, '13', 'HYSTER', 'E', 'A401/A402', '129', '电机温度传感器故障', '电机温度传感器连接有误；温度传感器故障；控制器内部故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (14, '14', 'HYSTER', 'E', 'A401/A402', '131', '主接触器驱动开路或短路', '主接触器开路或短路；连接管脚污损；错误的接线', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (15, '15', 'HYSTER', 'E', 'A401/A402', '134', '转向接触器驱动开路或短路', '转向接触器开路或短路；连接管脚污损；错误的接线', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (16, '16', 'HYSTER', 'E', 'A401/A402', '136', '行走电机编码器故障', '电机编码器故障；错误的接线', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (17, '17', 'HYSTER', 'E', 'A401/A402', '137', '行走电机开路', '一相或多相接线开路', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (18, '18', 'HYSTER', 'E', 'A401/A402', '138', '主接触器粘连', '主接触器触点熔接；电机 U 或V断开或缺相；存在连接B+接线端的电路向电容充电情况', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (19, '19', 'HYSTER', 'E', 'A401/A402', '139', '主接触器触点没有闭合', '主接触器触点氧化，熔化，或者连接状态不稳定；电容被外部器件充电；熔断器断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (20, '20', 'HYSTER', 'E', 'A401/A402', '146', 'EEPROM失效', '编程后默认设置没有导入', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (21, '21', 'HYSTER', 'E', 'A401/A402', '149', '参数变更失败故障', '为了保障车辆的安全性，一些特定参数的更改必须在钥匙开关重启动后才生效。', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (22, '22', 'HYSTER', 'E', 'A401/A402', '151', 'Can信号故障', '在500毫秒内液压控制器没有输送信息', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (23, '23', 'HYSTER', 'E', 'A401/A402', '152', 'Can通讯故障', '在100毫秒内通讯出现故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (24, '24', 'HYSTER', 'E', 'A401/A402', '153', '行走加速信号错误', '2个加速信号对比，在100毫秒内超过19.3%，加速器或线路故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (25, '25', 'HYSTER', 'E', 'A401/A402', '154', '方向信号错误', '2个加速信号对比，在100毫秒内超过19.4%，方向传感器器或线路故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (26, '26', 'HYSTER', 'E', 'A401/A402', '155', '加速器信号输入超出范围', '加速信号1小于 0.9V 或 大于 4.4V，加速信号2小于 0.35V 或大于 2.30V，加速传感器或线路', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (27, '27', 'HYSTER', 'E', 'A401/A402', '156', '方向信号超出范围', '方向信号1小于0.80V 或大于4.20V，方向信号2小于 0.30V或大于2.20V，方向传感器或线路', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (28, '28', 'HYSTER', 'E', 'A401/A402', '157', '行走控制器热量管理', '行走控制器导致行走加速降低大于25%', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (29, '29', 'HYSTER', 'E', 'A401/A402', '158', '行走电机热量管理', '行走电机导致行走加速降低大于25%', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (30, '30', 'HYSTER', 'E', 'A401/A402', '159', '液压控制器热量管理', '液压控制器导致行走加速降低大于25%', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (31, '31', 'HYSTER', 'E', 'A401/A402', '161', '液压电机热量管理', '液压电机导致行走加速降低大于25%', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (32, '32', 'HYSTER', 'E', 'A401/A402', '162', '显示器启动故障', '显示器在启动时无法进入操作模式', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (33, '33', 'HYSTER', 'E', 'A401/A402', '163', '中位启动故障', '输入信号不在中位位置', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (34, '34', 'HYSTER', 'E', 'A401/A402', '164', '座位开关开路', '启动顺序错误，座位开关未闭合作行走动作', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (35, '35', 'HYSTER', 'E', 'A401/A402', '165', '刹车和加速同时踩下', '建议释放刹车或加速器', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (36, '36', 'HYSTER', 'E', 'A401/A402', '166', '显示器Can通讯丧失', '显示器或线路故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (37, '37', 'HYSTER', 'E', 'A401/A402', '167', '行走控制器安装在液压控制器', '需重新安装', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (38, '38', 'HYSTER', 'E', 'A401/A402', '168', 'VCL 运行时间错误', 'VCL代码对运转时间超时', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (39, '39', 'HYSTER', 'E', 'A401/A402', '169', '外部电源输出超出范围', '外部负载在5V和12V 电源电流过大或过小', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (40, '40', 'HYSTER', 'E', 'A401/A402', '171', '操作系统故障', '内部控制器失效', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (41, '41', 'HYSTER', 'E', 'A401/A402', '173', '电机堵转', '电机堵转；电机编码器失效；错误的接线；输入电机编码器电源故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (42, '42', 'HYSTER', 'E', 'A401/A402', '189', '电机类型错误', '电机类型参数值超出范围', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (43, '43', 'HYSTER', 'E', 'A401/A402', '191', 'VCL/OS 不匹配', '控制器中的VCL程序与OS 程序不匹配', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (44, '44', 'HYSTER', 'E', 'A401/A402', '193', '编码器受限操作状态', '由于电机堵转或者编码器故障，使得受限操作状态被激活；错误的接线；车辆堵转', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (45, '45', 'HYSTER', 'E', 'A401/A402', '212', '控制器电流过载', '电机外部U,V 或W连接短路；电机参数不匹配；控制器故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (46, '46', 'HYSTER', 'E', 'A401/A402', '213', '电流传感器故障', '电机 U、V、W通过定子对车体短路，导致漏电；控制器故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (47, '47', 'HYSTER', 'E', 'A401/A402', '215', '控制器温度低于-40摄氏度', '控制器工作环境过于严酷', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (48, '48', 'HYSTER', 'E', 'A401/A402', '216', '控制器温度过高', '控制器工作环境过于严酷；车辆超载；控制器安装错误', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (49, '49', 'HYSTER', 'E', 'A401/A402', '217', '电压过低，低于25.6V', '电池参数设置错误；非控制器系统耗电；电池阻抗过大；电池连接断开；熔断器断开，或主接触器未连接', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (50, '50', 'HYSTER', 'E', 'A401/A402', '218', '电压过高，超过70V', '电池参数设置错误；电池阻抗过高；再生制动时电池；连接断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (51, '51', 'HYSTER', 'E', 'A401/A402', '222', '控制器温度过高导致性能消减', '控制器工作环境严酷；车辆超载；控制器安装不正确。超过85摄氏度', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (52, '52', 'HYSTER', 'E', 'A401/A402', '223', '电压过低性能消减，电容低于', '电池电量不足；电池参数设置错误；非控制器系统耗尽电量；电池阻抗过大；电池连接断开；熔断器断开或主接触器断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (53, '53', 'HYSTER', 'E', 'A401/A402', '224', '电压过高性能消减', '再生制动过程中再生制动电流导致电池电压升高；电池参数设置错误；电池阻抗过大；再生制动时电池连接断开', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (54, '54', 'HYSTER', 'E', 'A401/A402', '225', '控制器输出5V电源失效', '外接负载阻抗过低，电压超出正负10%的误差超过96毫秒', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (55, '55', 'HYSTER', 'E', 'A401/A402', '228', '电机过热导致性能消减', '电机温度达到或者高于程序设定的160度，导致电流输出降低；电机温度参数设定有误', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (56, '56', 'HYSTER', 'E', 'A401/A402', '229', '电机温度传感器故障', '电机温度传感器连接有误；温度传感器故障；控制器内部故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (57, '57', 'HYSTER', 'E', 'A401/A402', '236', '液压电机编码器故障', '电机编码器故障；错误的接线', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (58, '58', 'HYSTER', 'E', 'A401/A402', '237', '液压电机开路', '检查线路；错误的接线', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (59, '59', 'HYSTER', 'E', 'A401/A402', '241', '加速传感器电压高于5.5V', '线路或传感器故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (60, '60', 'HYSTER', 'E', 'A401/A402', '242', '加速传感器电压低于1.0V', '线路或传感器故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (61, '61', 'HYSTER', 'E', 'A401/A402', '245', '电位器低端电流过高', '电位器阻抗过低', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (62, '62', 'HYSTER', 'E', 'A401/A402', '246', 'EEPROM失效', '编程后默认设置没有导入', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (63, '63', 'HYSTER', 'E', 'A401/A402', '247', '高踏板保护/操作顺序失败', '钥匙启动，互锁，方向，以及加速器输入顺序设置错误；接线，开关钥匙，互锁，方向，或加速器输入故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (64, '64', 'HYSTER', 'E', 'A401/A402', '249', '参数变更失败故障', '为了保障车辆的安全性，一些特定参数的更改必须在钥匙开关重启动后才生效。', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (65, '65', 'HYSTER', 'E', 'A401/A402', '267', '液压控制器安装在行走控制器', '需重新安装', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (66, '66', 'HYSTER', 'E', 'A401/A402', '268', 'VCL 运行时间错误', 'VCL代码对运转时间超时', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (67, '67', 'HYSTER', 'E', 'A401/A402', '269', '外部电源输出超出范围', '外部负载在5V和12V 电源电流过大或过小', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (68, '68', 'HYSTER', 'E', 'A401/A402', '271', '操作系统故障', '内部控制器失效', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (69, '69', 'HYSTER', 'E', 'A401/A402', '272', 'PDO 超时', 'CAN PDO 信息接受时间超过了PDO时间限制', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (70, '70', 'HYSTER', 'E', 'A401/A402', '273', '电机堵转', '电机堵转；电机编码器失效；错误的接线；输入电机编码器电源故障', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (71, '71', 'HYSTER', 'E', 'A401/A402', '289', '电机类型错误', '电机类型参数值超出范围', NULL, NULL, NULL);
INSERT INTO `pm_fault_query` VALUES (72, '72', 'HYSTER', 'E', 'A401/A402', '291', 'VCL/OS 不匹配', '控制器中的VCL程序与OS 程序不匹配', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
