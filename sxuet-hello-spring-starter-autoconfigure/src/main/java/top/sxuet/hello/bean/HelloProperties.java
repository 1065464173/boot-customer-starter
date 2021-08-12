package top.sxuet.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: boot-customer-starter
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 20:48
 */
@ConfigurationProperties("sxuet.hello")
public class HelloProperties {
  private String prefix;
  private String suffix;

  public HelloProperties() {}

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
