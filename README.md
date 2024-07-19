# 本次项目只是为了加深对SpringCloud的学习

## 以下模块为基础部分

* mybatis_generator
* cloud_provider_payment8001
* cloud_consumer_order80
* cloud_api_commons

## 说明

**下面的模块为SpringCloud部分**

### 服务器的注册与发现

#### 首先consul的作用

* 能够帮助各个微服务模块快速找到相应的微服务模块访问地址
* 能够解决访问地址写死的问题

#### 然后就是consul的使用

* 先导入依赖

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-discovery</artifactId>
    <exclusions>
        <exclusion>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

* 然后编写yaml文件
* 随后在启动类上添加@EnableDiscoveryClient注解开启服务器发现

#### 注意bug

* consul自带负载均衡的功能
* 而RestTemplate这个类并不支持负载均衡
* 所以在将这个类加入到ioc容器的时候要声明@LoadBalance
* 这个注解会为这个类添加一个拦截器，然后将请求的地址中的服务逻辑名转为具体的服务地址

### 服务的统一配置管理

#### 还是使用consul达到目的，以下是它的作用

* 能够将所有的yaml文件进行统一配置
* 不过我们配置的是bootstrap.yaml,bootstrap.yaml会从外部先取得资源
* 这个外部就是在consul网站上自定义的yaml文件
* 它的优先级比一般的yaml文件高，不会被覆盖
* 它的作用类似于父类
* 可以用来集中其他微服务中application.yaml相同的部分
* 其余不同的部分还是交给application.yaml来管理

#### 如何使用

* 导入依赖

```
<!-- bootstrap -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
<!-- consul config -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-config</artifactId>
</dependency>
```
* 编写bootstrap.yaml，并且写入分离出来的配置（大概是公共的吧）
* 到consul打开的网站上创建一个文件，内部放三个文件分别对应三个测试环境
* 第一个文件为config，这个是头文件
* 内部再写三个xx-xx-dev，xx-xx-prod，xx-xx命名的文件
* 再在这三个文件下写一个命名data文件，文件为yaml格式
* 这样就能读取到外部的这些资源配置了

#### 如何使用动态刷新配置
* 所谓动态刷新配置，当我们更改外部的yaml的时候，读取数据同时跟着改变
* 在启动类上添加@ReFrashScope开启动态刷新
* 我们可以配置文件中更改刷新间隔，默认是55秒，一般我们不轻易修改改

#### consul配置持久化
* consul在启动后，我们配置的kv键值对会在consul服务器关闭后清除
* 为了使这些配置保留，所以要让其持久化