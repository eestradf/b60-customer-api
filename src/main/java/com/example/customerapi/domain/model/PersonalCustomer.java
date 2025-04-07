package com.example.customerapi.domain.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PersonalCustomer {
  private String id;
  private String name;
  private CustomerType customerType;
  private ContactInfo contactInfo;
  private LocalDate birthDate;
  private String identificationNumber;
  private Boolean isActive;
}
