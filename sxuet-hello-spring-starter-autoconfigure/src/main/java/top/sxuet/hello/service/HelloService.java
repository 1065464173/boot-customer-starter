package top.sxuet.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import top.sxuet.hello.bean.HelloProperties;

/**
 * @program: boot-customer-starter
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 20:46
 */

/** 默认不放容器中 */
public class HelloService {
  @Autowired HelloProperties helloProperties;

  public String sayHello(String userName) {
    return helloProperties.getPrefix() + ":" + userName + "》" + helloProperties.getSuffix();
  }
}
