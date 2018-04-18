# eureka学习

### eureka入门 - 服务注册与发现
1. 实现：一个服务注册中心，一个服务消费者
1. demo-eureka-server 服务注册中心demo
1. demo-eureka-client eureka客户端demo

### eureka服务消费者
1. 实现：对服务注册中心的demo-eureka-client服务远程调用
1. eureka-consumer：使用LoadBalancerClient查找服务连接信息，使用restTemplate调用服务
1. eureka-consumer-ribbon：使用ribbon实现用服务名调用服务
1. eureka-consumer-feign：使用feign实现的声明式服务调用客户端

### eureka-server-high-availability 高可用服务注册中心
1. 实现：启动三个服务注册中心，相互发现，一个服务注册中心发现一个服务，其余都可以发现该服务

### eureka-security 使用spring security保护注册中心
1. 实现：服务注册中心注册服务需要指定认证信息
1. eureka-security-server：服务注册中心，使用security保护服务注册中心
1. eureka-security-client：eureka客户端，注册服务指定认证信息

### eureka-feign-upload 使用feign实现文件上传
1. 实现：引入feign对表单提交的依赖，实现服务消费方发送文件
1. eureka-feign-upload-server：一个服务客户端，存在接收文件接口
1. eureka-feign-upload-client：一个服务客户端，对eureka-feign-upload-server接收文件接口实现feign远程调用发送文件