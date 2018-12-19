/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.24-log : Database - bms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bms`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `book_id` int(8) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(15) NOT NULL,
  `storagetime` date NOT NULL,
  `state` int(1) NOT NULL,
  `author` varchar(20) NOT NULL,
  `publishing_house` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`book_id`,`book_name`,`storagetime`,`state`,`author`,`publishing_house`) values (1,'计算机网络','2018-11-23',1,'谢希仁','人民邮电出版社'),(2,'Jsp实用教程','2018-11-22',1,'耿祥义','清华大学出版社'),(3,'Java EE开发','2018-12-10',0,'黑马','人民邮电出版社'),(6,'Div Css网页布局','2018-12-03',0,'刘丽霞','中国铁道出版社'),(7,'SSM框架','2018-12-04',0,'杨超','中国铁道出版社'),(8,'考研英语','2018-12-07',0,'何凯文','中国原子能出版社'),(9,'操作系统','2018-11-07',1,'谢旭升','机械工业出版社'),(10,'概率论与数理统计','2018-10-03',1,'盛聚','高等教育出版社'),(11,'Web程序设计','2018-12-05',1,'吕冰','河南大学出版社'),(12,'高等数学','2018-12-12',1,'杨超','高等教育出版社'),(13,'vds','2018-12-18',1,'poiuytrf','kjhgf'),(14,'毛泽东思想','2018-12-19',1,'杨超','人民邮电出版社');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`name`,`password`,`salt`) values (20,'tom','fbd3049de6fd898f4856288a085820c7','Gnm4m9Rrt2MLXc8e1FujIQ=='),(22,'Mike','2cc675c0f07e33f7be8c500b5620a1b0','q8/MAQ1J7g1vp6ncV6DE2g=='),(23,'竹坑','8f08deec35cc84529ff03ab1a2ec88f4','cTdrfsTyxDl3gE6x+/aUBA=='),(24,'test','22b6a08e3198bcb490f462365ed0be7f','/68dwjtJuN2x2sWp2FnQHg=='),(25,'明天','dabdb02eb3e6db73accb4215d702a4dc','4Zg1Nt7SDDKBs2gUhpXa2Q==');

/*Table structure for table `tbl_borrowing` */

DROP TABLE IF EXISTS `tbl_borrowing`;

CREATE TABLE `tbl_borrowing` (
  `student_id` int(5) DEFAULT NULL,
  `book_id` int(8) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  KEY `Student_ID` (`student_id`),
  KEY `Book_ID` (`book_id`),
  CONSTRAINT `Book_ID` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`book_id`),
  CONSTRAINT `Student_ID` FOREIGN KEY (`student_id`) REFERENCES `tbl_student` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_borrowing` */

/*Table structure for table `tbl_student` */

DROP TABLE IF EXISTS `tbl_student`;

CREATE TABLE `tbl_student` (
  `stu_id` int(5) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(10) NOT NULL,
  `stu_age` int(3) NOT NULL,
  `stu_gender` int(1) NOT NULL,
  `stu_class` varchar(7) NOT NULL,
  `stu_intake` date NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_student` */

insert  into `tbl_student`(`stu_id`,`stu_name`,`stu_age`,`stu_gender`,`stu_class`,`stu_intake`) values (1,'杨超',21,1,'B160416','2016-09-01'),(2,'王学孟',22,1,'B160416','2016-01-01'),(3,'刘波',22,1,'B160416','2016-01-01'),(4,'周源',22,1,'B160416','2016-09-01'),(5,'王岩杰',22,1,'B160416','2016-09-01'),(6,'于明坤',22,1,'B160416','2016-09-01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
