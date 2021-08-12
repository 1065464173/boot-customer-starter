package top.sxuet.boothellotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sxuet.hello.service.HelloService;

/**
 * @program: boot-customer-starter
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 20:59
 */
@RestController
public class HelloController {
  @Autowired HelloService helloService;

  @GetMapping("/hello")
  public String sayHello() {
    String ss = helloService.sayHello("张三");
    return ss;
  }
}
