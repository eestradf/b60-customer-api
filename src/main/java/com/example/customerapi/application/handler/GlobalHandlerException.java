package com.example.customerapi.application.handler;

import com.example.customerapi.domain.exception.BusinessCustomerNotFoundException;
import com.example.customerapi.domain.exception.PersonalCustomerNotFoundException;
import com.example.customerapi.domain.util.ConstantUtils;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalHandlerException {
  private final ExceptionProperties exceptionProperties;

  @ExceptionHandler({
    PersonalCustomerNotFoundException.class,
    BusinessCustomerNotFoundException.class
  })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionPayloadDto handleNotFoundException(Exception ex) {
    Map<String, String> errorMap =
        exceptionProperties.getErrors().get(ex.getClass().getSimpleName());

    return ExceptionPayloadDto.builder()
        .code(errorMap.get(ConstantUtils.CODE))
        .message(errorMap.get(ConstantUtils.MESSAGE))
        .traceId(UUID.randomUUID().toString())
        .timestamp(LocalDateTime.now().toString())
        .build();
  }

  @ExceptionHandler({WebExchangeBindException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionPayloadDto handleBadRequestException(WebExchangeBindException ex) {
    String requestErrors =
        ex.getFieldErrors().stream()
            .map(
                fieldError ->
                    fieldError.getObjectName()
                        + "."
                        + fieldError.getField()
                        + ": "
                        + fieldError.getDefaultMessage())
            .collect(Collectors.joining(", "));

    return ExceptionPayloadDto.builder()
        .code("400")
        .message(requestErrors)
        .traceId(UUID.randomUUID().toString())
        .timestamp(LocalDateTime.now().toString())
        .build();
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ExceptionPayloadDto handleInternalServerError(Exception ex) {

    log.info(ex.getMessage());

    return ExceptionPayloadDto.builder()
        .code("500")
        .message("Internal Server Error")
        .traceId(UUID.randomUUID().toString())
        .timestamp(LocalDateTime.now().toString())
        .build();
  }
}
