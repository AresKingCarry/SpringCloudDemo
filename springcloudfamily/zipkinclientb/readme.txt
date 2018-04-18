本模块是为了测试 服务链路追踪 zipkin ，而建立的zipkinclienta

配置文件中，配置了zipkin的地址：

spring:
  zipkin:
    base-url: http://localhost:9411

当调用zipkinclientb的时候，就会在zipkin中有记录。