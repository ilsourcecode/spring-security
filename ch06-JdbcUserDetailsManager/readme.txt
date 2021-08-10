ch06-JdbcUserDetailsManager：使用数据库，获取认证的用户信息
底层使用的是 spring-boot-starter-jdbc 的jdbcTemplate访问数据库，需要加入：web、security、jdbc、mysql依赖

实现步骤：
    1）新建maven
    2）加入依赖
        spring-boot-parent、web、security、jdbc、mysql依赖
    3）创建应用配置类，创建 JdbcUserDetailsManager 对象
        获取 users 表中的数据
    4）创建 security 的配置类，自定义安全配置信息，制定 JdbcUserDetailsService 类
    5）创建配置文件 application.yaml
        连接数据库，配置数据源
    6）测试
