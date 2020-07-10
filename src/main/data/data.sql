/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.62 : Database - storecode
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`storecode` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `storecode`;

/*Table structure for table `colortypeinfo` */

DROP TABLE IF EXISTS `colortypeinfo`;

CREATE TABLE `colortypeinfo` (
  `color_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `color_name` varchar(100) DEFAULT NULL COMMENT '颜色名称',
  `gt_id` int(10) DEFAULT NULL COMMENT '所属商品',
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `colortypeinfo` */

insert  into `colortypeinfo`(`color_id`,`color_name`,`gt_id`) values 
(2,'黑色',1),
(3,'蓝色',5),
(4,'蓝色',7),
(5,'橙色',1);

/*Table structure for table `goodsinfo` */

DROP TABLE IF EXISTS `goodsinfo`;

CREATE TABLE `goodsinfo` (
  `good_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `good_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `type_id` int(10) DEFAULT NULL COMMENT '种类',
  `color_id` int(10) DEFAULT NULL COMMENT '颜色',
  `buy_date` date DEFAULT NULL COMMENT '入手时间',
  `buy_price` decimal(10,2) DEFAULT NULL COMMENT '入手单价',
  `buy_value` int(10) DEFAULT NULL COMMENT '入手数量',
  `now_value` int(10) DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsinfo` */

/*Table structure for table `goodstypeinfo` */

DROP TABLE IF EXISTS `goodstypeinfo`;

CREATE TABLE `goodstypeinfo` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_nam` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `good_yf` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `good_zf` decimal(10,2) DEFAULT NULL COMMENT '总费用',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `goodstypeinfo` */

insert  into `goodstypeinfo`(`type_id`,`type_nam`,`good_yf`,`good_zf`) values 
(1,'商品A',NULL,NULL),
(4,'商品D',NULL,NULL),
(5,'商品E',NULL,NULL),
(7,'商品G',20.00,30.01);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`name`,`sex`) values 
(1,'张三','男'),
(2,'李四','女'),
(3,'王五','男');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
