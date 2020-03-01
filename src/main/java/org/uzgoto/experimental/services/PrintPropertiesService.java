package org.uzgoto.experimental.services;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.uzgoto.experimental.config.BarProperties;
import org.uzgoto.experimental.config.FooProperties;

import lombok.AllArgsConstructor;

@Configuration
@EnableConfigurationProperties({FooProperties.class, BarProperties.class})
@AllArgsConstructor
public class PrintPropertiesService {

  private final FooProperties fooProps;
  private final BarProperties barProps;

  public void print() {
    System.out.println(this.fooProps.toString());
    System.out.println(this.barProps.toString());
  }
}
