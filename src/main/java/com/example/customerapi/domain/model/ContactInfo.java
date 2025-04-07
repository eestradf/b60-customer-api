package com.example.customerapi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ContactInfo {
  private String email;
  private String phone;
  private Address address;
}
