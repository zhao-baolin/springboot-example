DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别 1男2女0未知',
  `age` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


insert  into `tb_user`(`id`,`user_name`,`sex`,`age`) values 
(1,'小明',1,20),
(2,'小花',2,17);
