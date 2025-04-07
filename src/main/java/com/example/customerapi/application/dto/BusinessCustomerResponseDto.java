package com.example.customerapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class BusinessCustomerResponseDto {
  private String id;
  private String name;
  private CustomerType customerType;
  private ContactInfo contactInfo;
  private String companyRegistrationNumber;
  private String companyNumber;
  private Boolean isActive;
}
