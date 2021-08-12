# boot-customer-starter
* a demo of self-created spring starter 
* 自定义sxuet-spring-boot-starter，记录starter的自定义步骤以及需要的过程
---
# 自定义过程
## 定义模块 xxx-spring-starter-autoconfigure
* 定义一个Spring初始化项目作为自动配置模块——其功能是在项目启动时自动添加场景配置
```xml
<!--Spring初始化项目-->
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.3</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
</dependencies>
```
* 必备文件一：xxxAutoConfiguration.java 自动配置类
```java
@Configuration //声明为一个配置文件类
@EnableConfigurationProperties(HelloProperties.class) // 依赖的配置文件类 默认放到容器中
public class HelloServiceAutoConfiguration {
  @ConditionalOnMissingBean(HelloService.class) //条件注入，容器中没有此类时引入
  @Bean
  public HelloService helloService() {
    return new HelloService();
  }
}
```
* 必备文件二：xxxProperties —— 配置类 存放配置信息
```java
@ConfigurationProperties("sxuet.hello") //自定义配置文件中的配置前缀
public class HelloProperties {
  //自定义配置属性
  private String prefix; 
  private String suffix;
  //生成配置属性的getter和setter
  public String getPrefix() {
    return prefix;
  }
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }
  public String getSuffix() {
    return suffix;
  }
  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}
```
* 必备文件三：resource/META-INF/spring.factories
SpringBoot加载项目的规范文件，使得项目启动加载指定的自动配置类。
```
#Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
top.sxuet.hello.auto.HelloServiceAutoConfiguration
#多个自动配置类分割使用 ‘,\’  最后一个不用
#例如 top.sxuet.hello.auto.HelloServiceAutoConfiguration,\
#    top.sxuet.hello.auto.ByeServiceAutoConfiguration
```
## 定义模块 xxx-spring-boot-starter
* 定义一个maven项目为场景启动器，定义好该启动器的唯一标识符`groupId`,`artifactId`,`version`
* 其中artifactId统一格式为 xxx-spring-boot-starter，意思为spring的第三方场景启动器

##收尾工作
定义好两个模块后，一个简易的starter就搭建完成了。
将两个模块使用maven工具install到本地仓库
* 最后定义一个test模块进行测试即可

