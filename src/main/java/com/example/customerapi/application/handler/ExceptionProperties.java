package com.example.customerapi.application.handler;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "exceptions")
public class ExceptionProperties {
  private Map<String, Map<String, String>> errors;
}
