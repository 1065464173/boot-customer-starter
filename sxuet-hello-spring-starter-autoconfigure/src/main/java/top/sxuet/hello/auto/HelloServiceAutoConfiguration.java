package top.sxuet.hello.auto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sxuet.hello.bean.HelloProperties;
import top.sxuet.hello.service.HelloService;

/**
 * @program: boot-customer-starter
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 20:50
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class) // 默认放到容器中
public class HelloServiceAutoConfiguration {
  public HelloServiceAutoConfiguration() {}

  @ConditionalOnMissingBean(HelloService.class)
  @Bean
  public HelloService helloService() {
    return new HelloService();
  }
}
