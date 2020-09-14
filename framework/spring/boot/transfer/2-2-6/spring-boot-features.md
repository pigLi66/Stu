# 本篇翻译 [spring-boot-features](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/html/spring-boot-features.html)


### 10.通过spring使用数据库
使用`JdbcTemplate` 可以完成ORM的操作，通过接口可以之间创建存储库，并且可以非常方便的完成一些操作 <br>
1. 配置数据源
javax.sql.DataSource interfacet提供了标准的使用数据连接的方法。传统
