/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : graduation-design-management

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-06-14 17:08:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(25) NOT NULL DEFAULT '',
  `admin_pwd` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123');

-- ----------------------------
-- Table structure for `base_dept`
-- ----------------------------
DROP TABLE IF EXISTS `base_dept`;
CREATE TABLE `base_dept` (
  `dept_id` varchar(4) NOT NULL,
  `dept_name` varchar(25) DEFAULT NULL,
  `dept_state` int(1) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `dept_name` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_dept
-- ----------------------------
INSERT INTO `base_dept` VALUES ('0001', '计算机与信息科学系', '1');
INSERT INTO `base_dept` VALUES ('0002', '外语系', '1');
INSERT INTO `base_dept` VALUES ('0003', '城管系', '1');

-- ----------------------------
-- Table structure for `base_major`
-- ----------------------------
DROP TABLE IF EXISTS `base_major`;
CREATE TABLE `base_major` (
  `major_id` varchar(4) NOT NULL,
  `major_name` varchar(25) DEFAULT NULL,
  `dept_id` varchar(4) DEFAULT NULL,
  `major_state` int(1) DEFAULT NULL,
  PRIMARY KEY (`major_id`),
  UNIQUE KEY `major_name` (`major_name`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `base_major_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `base_dept` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_major
-- ----------------------------
INSERT INTO `base_major` VALUES ('0001', '软件工程', '0001', '1');
INSERT INTO `base_major` VALUES ('0002', '物联网工程', '0001', '1');
INSERT INTO `base_major` VALUES ('0003', '计算机科学与技术', '0001', '1');
INSERT INTO `base_major` VALUES ('0004', '电子信息工程', '0001', '1');
INSERT INTO `base_major` VALUES ('0005', '商务英语', '0002', '1');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `c_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '建议编号',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `t_id` varchar(25) DEFAULT NULL,
  `f_id` bigint(20) DEFAULT NULL,
  `s_id` varchar(25) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`c_id`),
  KEY `t_id` (`t_id`),
  KEY `s_id` (`s_id`),
  KEY `f_id` (`f_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`f_id`) REFERENCES `myfile` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------


-- ----------------------------
-- Table structure for `mid_check`
-- ----------------------------
DROP TABLE IF EXISTS `mid_check`;
CREATE TABLE `mid_check` (
  `m_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '中期检查编号',
  `s_id` varchar(25) DEFAULT NULL,
  `f_id` bigint(20) DEFAULT NULL,
  `agree` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `s_id` (`s_id`),
  KEY `f_id` (`f_id`),
  CONSTRAINT `mid_check_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mid_check_ibfk_2` FOREIGN KEY (`f_id`) REFERENCES `myfile` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mid_check
-- ----------------------------


-- ----------------------------
-- Table structure for `myfile`
-- ----------------------------
DROP TABLE IF EXISTS `myfile`;
CREATE TABLE `myfile` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件编号',
  `f_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `f_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `upload_datetime` datetime DEFAULT NULL COMMENT '上传时间',
  `f_type` varchar(8) DEFAULT NULL COMMENT '文件类型',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myfile
-- ----------------------------


-- ----------------------------
-- Table structure for `open_report`
-- ----------------------------
DROP TABLE IF EXISTS `open_report`;
CREATE TABLE `open_report` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '开题报告编号',
  `f_id` bigint(20) DEFAULT NULL COMMENT '文件编号',
  `s_id` varchar(25) DEFAULT NULL COMMENT '学号',
  `agree` varchar(4) DEFAULT NULL COMMENT '是否同意开题',
  PRIMARY KEY (`r_id`),
  KEY `f_id` (`f_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `open_report_ibfk_1` FOREIGN KEY (`f_id`) REFERENCES `myfile` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `open_report_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of open_report
-- ----------------------------


-- ----------------------------
-- Table structure for `proj_book`
-- ----------------------------
DROP TABLE IF EXISTS `proj_book`;
CREATE TABLE `proj_book` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务书编号',
  `f_id` bigint(20) NOT NULL COMMENT '文件编号',
  `s_id` varchar(25) NOT NULL COMMENT '学生编号',
  `agree` varchar(4) DEFAULT NULL COMMENT '是否通过(待通过，不通过，通过)',
  PRIMARY KEY (`p_id`),
  KEY `s_id` (`s_id`),
  KEY `f_id` (`f_id`),
  CONSTRAINT `proj_book_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `proj_book_ibfk_2` FOREIGN KEY (`f_id`) REFERENCES `myfile` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proj_book
-- ----------------------------


-- ----------------------------
-- Table structure for `reply_group`
-- ----------------------------
DROP TABLE IF EXISTS `reply_group`;
CREATE TABLE `reply_group` (
  `reply_id` varchar(4) NOT NULL DEFAULT '',
  `reply_leader` varchar(25) DEFAULT NULL,
  `reply_member` varchar(255) DEFAULT NULL,
  `reply_place` varchar(10) DEFAULT NULL,
  `reply_datetime` datetime DEFAULT NULL,
  `batch` smallint(6) DEFAULT NULL,
  `reply_student` varchar(255) DEFAULT NULL,
  `creator` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `creator` (`creator`),
  CONSTRAINT `reply_group_ibfk_1` FOREIGN KEY (`creator`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_group
-- ----------------------------


-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `s_id` varchar(25) NOT NULL,
  `member_t_id` varchar(25) NOT NULL,
  `review_score` int(11) DEFAULT NULL,
  `review_comments` varchar(255) DEFAULT NULL,
  `reply_id` varchar(4) DEFAULT NULL,
  `review_type` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`member_t_id`),
  KEY `review_ibfk_3` (`reply_id`),
  KEY `member_t_id` (`member_t_id`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `review_ibfk_3` FOREIGN KEY (`reply_id`) REFERENCES `reply_group` (`reply_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `review_ibfk_4` FOREIGN KEY (`member_t_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------


-- ----------------------------
-- Table structure for `score_proportion`
-- ----------------------------
DROP TABLE IF EXISTS `score_proportion`;
CREATE TABLE `score_proportion` (
  `proportion_id` varchar(1) NOT NULL,
  `t_score_proportion` double DEFAULT NULL,
  `leader_score_proportion` double DEFAULT NULL,
  `review_score_proportion` double DEFAULT NULL,
  PRIMARY KEY (`proportion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score_proportion
-- ----------------------------
INSERT INTO `score_proportion` VALUES ('1', '0.5', '0.3', '0.2');

-- ----------------------------
-- Table structure for `select_title`
-- ----------------------------
DROP TABLE IF EXISTS `select_title`;
CREATE TABLE `select_title` (
  `s_id` varchar(25) NOT NULL COMMENT '学生编号',
  `titl_id` bigint(20) NOT NULL,
  `t_score` int(11) DEFAULT NULL COMMENT '指导教师评分',
  `t_comments` varchar(255) DEFAULT NULL COMMENT '指导教师评语',
  `reply_score` double DEFAULT NULL COMMENT '答辩评分',
  `reply_comments` varchar(255) DEFAULT NULL COMMENT '答辩评语',
  `seltitl_state` varchar(8) DEFAULT NULL COMMENT '选题状态(待同意，同意，拒绝，无效)',
  PRIMARY KEY (`s_id`,`titl_id`),
  KEY `titl_id` (`titl_id`),
  CONSTRAINT `select_title_ibfk_1` FOREIGN KEY (`titl_id`) REFERENCES `title` (`titl_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `select_title_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of select_title
-- ----------------------------


-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` varchar(25) NOT NULL,
  `s_name` varchar(16) NOT NULL,
  `s_pwd` varchar(25) NOT NULL,
  `s_class` varchar(32) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `batch` smallint(6) DEFAULT NULL,
  `s_state` int(11) DEFAULT NULL,
  `major_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `dept_id` (`dept`),
  KEY `major_id` (`major`),
  KEY `major_id_2` (`major_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`major_id`) REFERENCES `base_major` (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201533020111', '刘乐文', '123', '2015级物联网工程1班', '男', '22', '计算机与信息科学系', '物联网工程', '', '', '2', '1', '0002');
INSERT INTO `student` VALUES ('201535020111', '蔡徐坤同学', '123', '2015级软工1班', '男', '21', '计算机与信息科学系', '软件工程', '13426809893', '705038642@qq.com', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020333', '张大大', '123', '2015级商英3班', '男', '21', '外语系', '商务英语', '13426809893', '705038642@qq.com', '1', '1', '0005');
INSERT INTO `student` VALUES ('201535020502', '宋志杨', '123', '2015级软工5班', '男', '21', '计算机与信息科学系', '软件工程', '13426809893', '705038642@qq.com', '1', '1', '0001');
INSERT INTO `student` VALUES ('201535020505', '张小明', '123', '2015级软工5班', '男', '22', '计算机与信息科学系', '软件工程', '111', '705038642@qq.com', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020533', '冯肇威', '123', '2015级软工5班', '男', '22', '计算机与信息科学系', '软件工程', '13426809893', '705038642@qq.com', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020601', '蔡柏轩啊', '123', '2015级软工6班', '男', '21', '计算机与信息科学系', '软件工程', '13426809893', '11113333@qq.com', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020616', '梁斌', '123', '2015级软工6班', '男', '21', '计算机与信息科学系', '软件工程', '13426809893', '705038642@qq.com', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020631', '颜扬乐', '123', '2015级软工6班', '男', '21', '计算机与信息科学系', '软件工程', '13426809893', '705038642@qq.com', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020636', '尹少俊', '123', '2015级软工6班', '男', '21', '计算机与信息科学系', '软件工程', '13426809893', '', '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020637', '有意见', '123', '2015级软工6班', '男', '22', '计算机与信息科学系', '软件工程', '1111', null, '2', '1', '0001');
INSERT INTO `student` VALUES ('201535020639', '曾永权', '123', '2015级软工6班', '男', '21', '计算机与信息科学系', '软件工程', '111222', '111242424', '2', '1', '0001');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` varchar(25) NOT NULL,
  `t_name` varchar(16) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `t_pwd` varchar(25) DEFAULT NULL,
  `dept` varchar(32) DEFAULT NULL,
  `major` varchar(32) DEFAULT NULL,
  `title` varchar(16) DEFAULT NULL,
  `duties` varchar(16) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `power` varchar(2) DEFAULT NULL,
  `t_state` int(1) DEFAULT NULL COMMENT '1:正常 0:暂停',
  `dept_id` varchar(4) DEFAULT NULL,
  `major_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `dept_id` (`dept_id`),
  KEY `major_id` (`major_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `base_dept` (`dept_id`),
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`major_id`) REFERENCES `base_major` (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2000', '评阅教师0', null, null, '123', '计算机与信息科学系', '无', '讲师', '教师', '', '110@qq.com', '否', '1', '0001', null);
INSERT INTO `teacher` VALUES ('2001', '评阅教师1', null, null, '123', '计算机与信息科学系', '无', '讲师', '教师', '', '705038642@qq.com', '否', '1', '0001', null);
INSERT INTO `teacher` VALUES ('20080040', '张三三', '男', '33', '123', '计算机与信息科学系', '无', '讲师', '教师', '', '110@qq.com', '否', '1', '0001', null);
INSERT INTO `teacher` VALUES ('20080041', '李四', '男', '40', '123', '外语系', '无', '讲师', '教师', '120', '120@qq.com', '否', '1', '0002', null);
INSERT INTO `teacher` VALUES ('20080044', '王五', '男', '28', '123', '计算机与信息科学系', '无', '讲师', '教师', '119', '119@qq.com', '否', '1', '0001', null);
INSERT INTO `teacher` VALUES ('20080045', '蔡徐坤', '男', '29', '123', '计算机与信息科学系', '软件工程', '副教授', '教研室主任', '122', '122@qq.com', '是', '1', '0001', '0001');
INSERT INTO `teacher` VALUES ('2008888', '张永财', null, null, '123', '计算机与信息科学系', '无', '讲师', '教师', '111222', '110@qq.com', '否', '1', '0001', null);

-- ----------------------------
-- Table structure for `thesis`
-- ----------------------------
DROP TABLE IF EXISTS `thesis`;
CREATE TABLE `thesis` (
  `thesis_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '论文编号',
  `s_id` varchar(25) DEFAULT NULL COMMENT '学生编号',
  `titl_id` bigint(20) DEFAULT NULL COMMENT '课题编号',
  `f_id` bigint(20) DEFAULT NULL COMMENT '文件编号',
  `agree` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`thesis_id`),
  KEY `titl_id` (`titl_id`),
  KEY `s_id` (`s_id`),
  KEY `f_id` (`f_id`),
  CONSTRAINT `thesis_ibfk_1` FOREIGN KEY (`titl_id`) REFERENCES `title` (`titl_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `thesis_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `thesis_ibfk_3` FOREIGN KEY (`f_id`) REFERENCES `myfile` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thesis
-- ----------------------------


-- ----------------------------
-- Table structure for `thesis_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `thesis_attachment`;
CREATE TABLE `thesis_attachment` (
  `a_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_id` bigint(20) DEFAULT NULL,
  `s_id` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`a_id`),
  KEY `f_id` (`f_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `thesis_attachment_ibfk_1` FOREIGN KEY (`f_id`) REFERENCES `myfile` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `thesis_attachment_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thesis_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for `title`
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `titl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titl_name` varchar(32) DEFAULT NULL,
  `t_id` varchar(25) DEFAULT NULL,
  `titl_source` varchar(25) DEFAULT NULL,
  `titl_type` varchar(25) DEFAULT NULL,
  `titl_describe` varchar(255) DEFAULT NULL,
  `titl_state` varchar(7) DEFAULT NULL,
  `sel_state` varchar(4) DEFAULT NULL,
  `major` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`titl_id`),
  KEY `t_id` (`t_id`),
  CONSTRAINT `title_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of title
-- ----------------------------


-- ----------------------------
-- View structure for `midcheckinfo`
-- ----------------------------
DROP VIEW IF EXISTS `midcheckinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `midcheckinfo` AS select `mid_check`.`m_id` AS `m_id`,`mid_check`.`f_id` AS `f_id`,`mid_check`.`s_id` AS `s_id`,`mid_check`.`agree` AS `agree`,`myfile`.`f_name` AS `f_name`,`myfile`.`f_path` AS `f_path`,`myfile`.`upload_datetime` AS `upload_datetime`,`myfile`.`f_type` AS `f_type`,`teacher`.`t_id` AS `t_id`,`teacher`.`t_name` AS `t_name`,`student`.`s_name` AS `s_name`,`select_title`.`seltitl_state` AS `seltitl_state`,`title`.`titl_name` AS `titl_name`,`student`.`major` AS `major`,`student`.`batch` AS `batch` from (((((`mid_check` join `myfile` on((`mid_check`.`f_id` = `myfile`.`f_id`))) join `teacher`) join `student` on((`mid_check`.`s_id` = `student`.`s_id`))) join `select_title` on((`select_title`.`s_id` = `mid_check`.`s_id`))) join `title` on(((`select_title`.`titl_id` = `title`.`titl_id`) and (`title`.`t_id` = `teacher`.`t_id`)))) ;

-- ----------------------------
-- View structure for `openreportinfo`
-- ----------------------------
DROP VIEW IF EXISTS `openreportinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `openreportinfo` AS select `open_report`.`r_id` AS `r_id`,`open_report`.`f_id` AS `f_id`,`open_report`.`s_id` AS `s_id`,`open_report`.`agree` AS `agree`,`myfile`.`f_name` AS `f_name`,`myfile`.`f_path` AS `f_path`,`myfile`.`upload_datetime` AS `upload_datetime`,`myfile`.`f_type` AS `f_type`,`teacher`.`t_id` AS `t_id`,`teacher`.`t_name` AS `t_name`,`student`.`s_name` AS `s_name`,`select_title`.`seltitl_state` AS `seltitl_state`,`title`.`titl_name` AS `titl_name`,`student`.`major` AS `major`,`student`.`batch` AS `batch` from (((((`open_report` join `myfile` on((`open_report`.`f_id` = `myfile`.`f_id`))) join `teacher`) join `student` on((`open_report`.`s_id` = `student`.`s_id`))) join `select_title` on((`select_title`.`s_id` = `open_report`.`s_id`))) join `title` on(((`select_title`.`titl_id` = `title`.`titl_id`) and (`title`.`t_id` = `teacher`.`t_id`)))) ;

-- ----------------------------
-- View structure for `projbookinfo`
-- ----------------------------
DROP VIEW IF EXISTS `projbookinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `projbookinfo` AS select `proj_book`.`p_id` AS `p_id`,`proj_book`.`f_id` AS `f_id`,`proj_book`.`s_id` AS `s_id`,`proj_book`.`agree` AS `agree`,`myfile`.`f_name` AS `f_name`,`myfile`.`f_path` AS `f_path`,`myfile`.`upload_datetime` AS `upload_datetime`,`myfile`.`f_type` AS `f_type`,`teacher`.`t_id` AS `t_id`,`teacher`.`t_name` AS `t_name`,`student`.`s_name` AS `s_name`,`select_title`.`seltitl_state` AS `seltitl_state`,`title`.`titl_name` AS `titl_name`,`student`.`major` AS `major`,`student`.`batch` AS `batch` from (((((`proj_book` join `myfile` on((`proj_book`.`f_id` = `myfile`.`f_id`))) join `teacher`) join `student` on((`proj_book`.`s_id` = `student`.`s_id`))) join `select_title` on((`select_title`.`s_id` = `proj_book`.`s_id`))) join `title` on(((`select_title`.`titl_id` = `title`.`titl_id`) and (`title`.`t_id` = `teacher`.`t_id`)))) ;

-- ----------------------------
-- View structure for `thesisinfo`
-- ----------------------------
DROP VIEW IF EXISTS `thesisinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `thesisinfo` AS select `thesis`.`thesis_id` AS `thesis_id`,`thesis`.`f_id` AS `f_id`,`thesis`.`s_id` AS `s_id`,`thesis`.`agree` AS `agree`,`thesis`.`titl_id` AS `titl_id`,`myfile`.`f_name` AS `f_name`,`myfile`.`f_path` AS `f_path`,`myfile`.`upload_datetime` AS `upload_datetime`,`myfile`.`f_type` AS `f_type`,`teacher`.`t_id` AS `t_id`,`teacher`.`t_name` AS `t_name`,`student`.`s_name` AS `s_name`,`select_title`.`seltitl_state` AS `seltitl_state`,`title`.`titl_name` AS `titl_name`,`student`.`major` AS `major`,`student`.`batch` AS `batch` from (((((`thesis` join `myfile` on((`thesis`.`f_id` = `myfile`.`f_id`))) join `teacher`) join `student` on((`thesis`.`s_id` = `student`.`s_id`))) join `select_title` on((`select_title`.`s_id` = `thesis`.`s_id`))) join `title` on(((`select_title`.`titl_id` = `title`.`titl_id`) and (`title`.`t_id` = `teacher`.`t_id`)))) ;

-- ----------------------------
-- View structure for `reviewscore`
-- ----------------------------
DROP VIEW IF EXISTS `reviewscore`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reviewscore` AS select `thesisinfo`.`f_id` AS `f_id`,`review`.`review_score` AS `review_score`,`review`.`review_comments` AS `review_comments`,`review`.`reply_id` AS `reply_id`,`thesisinfo`.`agree` AS `agree`,`review`.`member_t_id` AS `member_t_id`,`thesisinfo`.`t_id` AS `t_id`,`thesisinfo`.`titl_name` AS `titl_name`,`thesisinfo`.`major` AS `major`,`thesisinfo`.`batch` AS `batch`,`thesisinfo`.`titl_id` AS `titl_id`,`thesisinfo`.`s_name` AS `s_name`,`thesisinfo`.`t_name` AS `t_name`,`thesisinfo`.`f_name` AS `f_name`,`teacher`.`t_name` AS `member_t_name`,`review`.`review_type` AS `review_type`,`reply_group`.`reply_leader` AS `reply_leader`,`thesisinfo`.`s_id` AS `s_id`,`select_title`.`reply_score` AS `reply_score` from ((((`thesisinfo` join `review` on((`review`.`s_id` = `thesisinfo`.`s_id`))) join `teacher` on((`review`.`member_t_id` = `teacher`.`t_id`))) join `reply_group` on((`review`.`reply_id` = `reply_group`.`reply_id`))) join `select_title` on(((`select_title`.`s_id` = `thesisinfo`.`s_id`) and (`select_title`.`titl_id` = `thesisinfo`.`titl_id`)))) ;

-- ----------------------------
-- View structure for `seltitleinfo`
-- ----------------------------
DROP VIEW IF EXISTS `seltitleinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `seltitleinfo` AS select `title`.`titl_id` AS `titl_id`,`title`.`titl_name` AS `titl_name`,`title`.`t_id` AS `t_id`,`title`.`titl_source` AS `titl_source`,`title`.`titl_type` AS `titl_type`,`title`.`titl_describe` AS `titl_describe`,`title`.`titl_state` AS `titl_state`,`title`.`sel_state` AS `sel_state`,`select_title`.`seltitl_state` AS `seltitl_state`,`teacher`.`t_name` AS `t_name`,`select_title`.`s_id` AS `s_id`,`title`.`major` AS `major`,`student`.`s_name` AS `s_name` from (((`title` join `select_title` on((`select_title`.`titl_id` = `title`.`titl_id`))) join `teacher` on((`title`.`t_id` = `teacher`.`t_id`))) join `student` on((`select_title`.`s_id` = `student`.`s_id`))) ;

-- ----------------------------
-- View structure for `ss`
-- ----------------------------
DROP VIEW IF EXISTS `ss`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ss` AS select `select_title`.`s_id` AS `s_id`,`select_title`.`titl_id` AS `titl_id`,`select_title`.`t_score` AS `t_score`,`select_title`.`t_comments` AS `t_comments`,`select_title`.`reply_score` AS `reply_score`,`select_title`.`reply_comments` AS `reply_comments`,`select_title`.`seltitl_state` AS `seltitl_state`,`student`.`s_name` AS `s_name`,`student`.`s_pwd` AS `s_pwd`,`student`.`s_class` AS `s_class`,`student`.`sex` AS `sex`,`student`.`age` AS `age`,`student`.`dept` AS `dept`,`student`.`major` AS `major`,`student`.`phone` AS `phone`,`student`.`email` AS `email`,`student`.`batch` AS `batch` from (`select_title` join `student` on((`student`.`s_id` = `select_title`.`s_id`))) ;

-- ----------------------------
-- View structure for `sss`
-- ----------------------------
DROP VIEW IF EXISTS `sss`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sss` AS select `teacher`.`t_name` AS `t_name`,`title`.`titl_id` AS `titl_id`,`title`.`titl_name` AS `titl_name`,`title`.`t_id` AS `t_id`,`title`.`titl_source` AS `titl_source`,`title`.`titl_type` AS `titl_type`,`title`.`titl_describe` AS `titl_describe`,`title`.`titl_state` AS `titl_state`,`title`.`sel_state` AS `sel_state`,`title`.`major` AS `major` from (`title` join `teacher` on((`title`.`t_id` = `teacher`.`t_id`))) ;

-- ----------------------------
-- View structure for `studentscore`
-- ----------------------------
DROP VIEW IF EXISTS `studentscore`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `studentscore` AS select `title`.`titl_name` AS `titl_name`,`select_title`.`reply_comments` AS `reply_comments`,`select_title`.`reply_score` AS `reply_score`,`select_title`.`t_comments` AS `t_comments`,`select_title`.`t_score` AS `t_score`,`select_title`.`seltitl_state` AS `seltitl_state`,`select_title`.`titl_id` AS `titl_id`,`select_title`.`s_id` AS `s_id`,`teacher`.`t_id` AS `t_id`,`teacher`.`t_name` AS `t_name`,`student`.`s_name` AS `s_name`,`student`.`batch` AS `batch`,`student`.`major` AS `major` from (((`select_title` join `title` on((`title`.`titl_id` = `select_title`.`titl_id`))) join `teacher` on((`teacher`.`t_id` = `title`.`t_id`))) join `student` on((`select_title`.`s_id` = `student`.`s_id`))) ;

-- ----------------------------
-- View structure for `thesisattachmentinfo`
-- ----------------------------
DROP VIEW IF EXISTS `thesisattachmentinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `thesisattachmentinfo` AS select `teacher`.`t_id` AS `t_id`,`teacher`.`t_name` AS `t_name`,`title`.`titl_name` AS `titl_name`,`select_title`.`seltitl_state` AS `seltitl_state`,`thesis_attachment`.`a_id` AS `a_id`,`thesis_attachment`.`f_id` AS `f_id`,`thesis_attachment`.`s_id` AS `s_id`,`student`.`s_name` AS `s_name`,`student`.`s_class` AS `s_class`,`student`.`major` AS `major`,`myfile`.`f_name` AS `f_name`,`myfile`.`f_path` AS `f_path`,`myfile`.`upload_datetime` AS `upload_datetime`,`myfile`.`f_type` AS `f_type`,`student`.`batch` AS `batch` from (((((`thesis_attachment` join `student` on((`student`.`s_id` = `thesis_attachment`.`s_id`))) join `myfile` on((`myfile`.`f_id` = `thesis_attachment`.`f_id`))) join `select_title` on((`thesis_attachment`.`s_id` = `select_title`.`s_id`))) join `title` on((`select_title`.`titl_id` = `title`.`titl_id`))) join `teacher` on((`title`.`t_id` = `teacher`.`t_id`))) ;

-- ----------------------------
-- View structure for `titleinfo`
-- ----------------------------
DROP VIEW IF EXISTS `titleinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `titleinfo` AS select `teacher`.`t_name` AS `t_name`,`title`.`titl_id` AS `titl_id`,`title`.`titl_name` AS `titl_name`,`title`.`t_id` AS `t_id`,`title`.`titl_source` AS `titl_source`,`title`.`titl_type` AS `titl_type`,`title`.`titl_describe` AS `titl_describe`,`title`.`titl_state` AS `titl_state`,`title`.`sel_state` AS `sel_state`,`title`.`major` AS `major` from (`title` join `teacher` on((`teacher`.`t_id` = `title`.`t_id`))) ;
