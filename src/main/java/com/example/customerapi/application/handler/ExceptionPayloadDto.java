package com.example.customerapi.application.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ExceptionPayloadDto {
  private String code;
  private String message;
  private String traceId;
  private String timestamp;
}
