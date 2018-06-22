# config 配置中心学习
官方文档链接：http://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.0.0.RC2/single/spring-cloud-config.html

### demo-config-server-git : 配置中心demo
创建一个配置中心的步骤
1. spring boot项目，maven配置文件中引入`spring-cloud-config-server`依赖
1. 配置类中添加注解`@EnableConfigServer`
1. 在配置文件中添加服务信息、配置仓库信息，这里以git为配置仓库形式（从配置属性中可知其他形式也可实现，如SVN。vault等，但未接触过）

访问配置信息的URL与配置文件的映射关系如下：
- /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.properties

配置完成，可以通过访问 ：`http://{host}:{server.port}/{application}/{profile}/{label}`查看对应环境的项目配置信息，
如：http://localhost:9000/demo-config-client/default/master

### demo-config-client : 从配置中心获取配置信息的客户端demo
创建一个从配置中心获取配置信息的客户端的步骤
1. spring boot项目，maven配置文件中引入`spring-cloud-starter-config`依赖
1. 配置类中添加注解`@EnableDiscoveryClient`
1. bootstrap.properties/bootstrap.yml中添加服务信息、配置中心信息

### demo-config-datasource-client : 测试数据库相关配置迁移配置中心刷新情况
spring管理的bean的配置属性动态刷新步骤：如DataSource的配置
1. 配置对应bean
1. bean的配置类和方法上添加`@RefreshScope`注解即可，注意添加该注解的类不能被`final`修饰

此项目主要用于测试可以放入仓库配置文件中的属性（数据库相关），下面是测试项
- 项目启动端口 - 可行
- actuator端点配置 - 可行，使用`http://localhost:9002/actuator/refresh`测试
- 数据库配置 - 可行,数据库配置会刷新
- 数据库 + flyway数据库版本控制配置 - 不可行，切换数据库时flyway并不会初始化执行，不会报错，但若切换的数据库未执行flyway版本控制，两个数据库的表结构不一致，会导致数据库操作异常。<br/>
理论上可以参照`org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration`的实现重写flyway配置，使刷新数据库时flyway.migrate数据库迁移方法重新执行，这里暂时不做研究。。。

### demo-config-server-crypto : 配置中心配置内容的加密与解密
