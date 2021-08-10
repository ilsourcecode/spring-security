ch05-InMemoryUserDetailsManager：使用 InMemoryUserDetailsManager 管理内存中的用户信息！
实现步骤：
    1、新建maven：quickstart
    2、加入依赖 gav 坐标
        1）springboot：2.4.1
        2）spring-boot-starter-web
        3）spring-boot-starter-security
        4）spring-boot-maven-plugin springboot 的编译插件
    3、创建应用的配置类
        1）创建密码的处理对象
        2）使用 InMemoryUserDetailsManager 创建用户
    4、创建类继承 WebSecurityConfigurerAdapter
        1）自动注入 UserDetailsService 对象
        2）重写 protected void configure(HttpSecurity http) throws Exception 方法
