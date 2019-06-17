# SSM个人博客
## 关于项目
---

该博客是基于SSM实现的一个个人博客系统，适合初学SSM和个人博客制作的同学学习。 
主要涉及技术包括的包括 Maven、Spring、SpringMVC、MyBatis、JSP等。 
前端采用Layui框架和用了一个网站的前台样式。 



## 效果预览
---

预览地址：interesting1996.shop



## 使用注意
1.开发工具的选择
请使用 IntelliJ IDEA, 尽量不要用 Eclipse/MyEclipse，使用前者项目起不来我可以帮忙解决，后者直接忽视(理论上可以起)

2.确保你安装了 Maven

3.请安装 Lombok 插件
代码中多次使用 @Data 注解，请确保你的 IDE 安装了 Lombok 插件，否则找不到 getter/setter 方法
无序

## 使用步骤

1、克隆项目 
克隆或者下载项目到本地，解压，主要分为两个部分：Blog和 blog.sql 
Blog: 完整项目源码, 可以使用 IDEA 导入或者打开 
blog.sql: 数据库文件，请先创建数据库，然后以运行sql文件方式导入 

2.使用 IDEA 导入项目
确保你安装了 Maven，导入项目时，选择已存在的项目，类型是 Maven 项目

3、 导入数据库 
新建数据库 blog，导入数据库（即blog.sql）。
数据库默认用户名 root，密码 123456

4、修改项目中的数据库连接信息 
修改 db.properties 文件，该文件很容易找到，在 src/main/resources 中
里面有 MySQL, 请确保已安装和启动 MySQL 
注意修改数据库地址、表名、用户名和密码。

