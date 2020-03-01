package org.uzgoto.experimental.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Value;

@ConstructorBinding
@ConfigurationProperties("bar")
@Value
public class BarProperties {
  String id;
  String host;
  int port;
}
