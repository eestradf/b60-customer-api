package com.example.customerapi.infrastructure.repository.document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document(collection = "business_customer")
public class BusinessCustomerDocument {

  @Id private String id;
  private String name;
  private String customerType;
  private String email;
  private String phone;
  private String country;
  private String province;
  private String district;
  private String postalCode;
  private String companyRegistrationNumber;
  private String companyNumber;
  private Boolean isActive;
}
