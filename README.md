# demo_Beanandmysql_role
基于eclipse实现由jsp+bean+jdbc+mysql，实现不同用户权限登录获取不同内容，同样支持增删改查
# 全网最使用MySQL， JSP, Bean, JDBC(连接数据库) ，制作有权限（老师，学生，辅导员） 用户登录demo，表单查看demo


- 闲暇之余，创作不易，望大家能够多多支持！
- 下面是本人的博客CSDN（简书）【多多关注哦！】
 https://www.jianshu.com/u/764ba4775587
  https://blog.csdn.net/m0_48851832/article/details/124759859?spm=1001.2014.3001.5501

 

- -后期会有关于一系列关于java后端的小项目
- 因为在学校为了完成作业所以使用esclipse,后期就不会了
- 后期会使用idea创作项目
- 后期会有Spring  Spring -Boot  Spring-cloud ,mybatis ,mybatis-plus,等相关技术栈项目


### 1.准备相关数据,创建数据库（Lab_db）

```
create database Lab_DB DEFAULT CHAR SET utf8;  /*创建数据库Lab_db*/
use Lab_DB;                                     /*使用数据库Lab_db*/
/*创建表结构*/
create table user(id_user int not null auto_increment,account varchar(10)not null,
password varchar(10)null,username varchar(10)null,gender varchar(2)null ,
department varchar(20)null,access_rights varchar(10),primary key (id_user));
```

### 2.写入测试数据

```
insert into user(account, password, username, gender, department, access_rights)
values('demo005','007','小wa哥','男','技术','老师');
insert into user(account, password, username, gender, department, access_rights)
values('demo006','007','小wa哥','女','计算机','辅导员');
insert into user(account, password, username, gender, department, access_rights)
values('demo008','007','小wa哥','男','技术','辅导员');
insert into user(account, password, username, gender, department, access_rights)
values('demo009','007','小wa哥','男','技术','老师');
insert into user(account, password, username, gender, department, access_rights)
values('demo001','007','小wa哥','男','技术','老师');
insert into user(account, password, username, gender, department, access_rights)
values('demo002','007','小wa哥','男','技术','老师');
select * from user;
```

### 目录结构

- bean.demo	
  - ContentBean
  - dataBean
- JDBC(用于测试数据库连接是否成功！)
  - JDBCdemo
- servlet.demo
  - deleteDemo
  - updataDemo
  - registerDemo
- WEB
  - index.html
  - conentbeanDemo.jsp
  - user.html

---

