package com.example.customerapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Address {
  private String country;
  private String province;
  private String district;
  private String postalCode;
}
