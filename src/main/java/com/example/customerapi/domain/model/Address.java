package com.example.customerapi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Address {
  private String country;
  private String province;
  private String district;
  private String postalCode;
}
