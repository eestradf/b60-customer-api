package com.example.customerapi.application.dto;

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
