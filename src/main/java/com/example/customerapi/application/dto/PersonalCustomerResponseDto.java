package com.example.customerapi.application.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class PersonalCustomerResponseDto {
  private String id;
  private String name;
  private CustomerType customerType;
  private ContactInfo contactInfo;
  private LocalDate birthDate;
  private String identificationNumber;
  private Boolean isActive;
}
