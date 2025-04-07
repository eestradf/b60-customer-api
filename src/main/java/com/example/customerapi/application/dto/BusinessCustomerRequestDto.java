package com.example.customerapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class BusinessCustomerRequestDto {
  private String name;
  private CustomerType customerType;
  private String email;
  private String phone;
  private String country;
  private String province;
  private String district;
  private String postalCode;
  private String companyRegistrationNumber;
  private String companyNumber;
}
