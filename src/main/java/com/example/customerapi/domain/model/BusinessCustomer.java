package com.example.customerapi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BusinessCustomer {
  private String id;
  private String name;
  private CustomerType customerType;
  private ContactInfo contactInfo;
  private String companyRegistrationNumber;
  private String companyNumber;
  private Boolean isActive;
}
