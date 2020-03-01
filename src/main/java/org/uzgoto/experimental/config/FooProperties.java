package org.uzgoto.experimental.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Value;

@ConstructorBinding
@ConfigurationProperties("foo")
@Value
public class FooProperties {
  int code;
  String message;
  String addition;
}
