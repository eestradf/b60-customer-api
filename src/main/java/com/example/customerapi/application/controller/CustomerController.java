package com.example.customerapi.application.controller;

import com.example.customerapi.application.dto.BusinessCustomerRequestDto;
import com.example.customerapi.application.dto.BusinessCustomerResponseDto;
import com.example.customerapi.application.dto.PersonalCustomerRequestDto;
import com.example.customerapi.application.dto.PersonalCustomerResponseDto;
import com.example.customerapi.application.mapper.CustomerInitMapper;
import com.example.customerapi.domain.model.BusinessCustomer;
import com.example.customerapi.domain.model.PersonalCustomer;
import com.example.customerapi.domain.port.in.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerUseCase customerUseCase;
  private final CustomerInitMapper customerInitMapper;

  @GetMapping("/personal")
  public Flux<PersonalCustomerResponseDto> getPersonalCustomers() {
    return this.customerUseCase
        .getAllPersonalCustomers()
        .map(this.customerInitMapper::toPersonalCustomerResponseDto);
  }

  @GetMapping("/personal/{personal-customer-id}")
  public Mono<PersonalCustomerResponseDto> getPersonalCustomerById(
      @PathVariable("personal-customer-id") String personalCustomerId) {
    return this.customerUseCase
        .getPersonalCustomerById(personalCustomerId)
        .map(this.customerInitMapper::toPersonalCustomerResponseDto);
  }

  @GetMapping("/business/{business-customer-id}")
  public Mono<BusinessCustomerResponseDto> getBusinessCustomerById(
      @PathVariable("business-customer-id") String businessCustomerId) {
    return this.customerUseCase
        .getBusinessCustomerById(businessCustomerId)
        .map(this.customerInitMapper::toBusinessCustomerResponseDto);
  }

  @PostMapping("/personal")
  public Mono<Void> createPersonalCustomer(
      @RequestBody PersonalCustomerRequestDto personalCustomerRequestDto) {
    PersonalCustomer personalCustomer =
        this.customerInitMapper.toPersonalCustomer(personalCustomerRequestDto);

    return this.customerUseCase.savePersonalCustomer(personalCustomer);
  }

  @PostMapping("/business")
  public Mono<Void> createBusinessCustomer(
      @RequestBody BusinessCustomerRequestDto businessCustomerRequestDto) {
    BusinessCustomer businessCustomer =
        this.customerInitMapper.toBusinessCustomer(businessCustomerRequestDto);

    return this.customerUseCase.saveBusinessCustomer(businessCustomer);
  }

  @PutMapping("/personal/{personal-customer-id}")
  public Mono<Void> updatePersonalCustomer(
      @PathVariable("personal-customer-id") String personalCustomerId,
      @RequestBody PersonalCustomerRequestDto personalCustomerRequestDto) {
    PersonalCustomer personalCustomer =
        this.customerInitMapper.toPersonalCustomer(personalCustomerRequestDto);

    return this.customerUseCase.updatePersonalCustomer(personalCustomerId, personalCustomer);
  }

  @PutMapping("/business/{business-customer-id}")
  public Mono<Void> updateBusinessCustomer(
      @PathVariable("business-customer-id") String businessCustomerId,
      @RequestBody BusinessCustomerRequestDto businessCustomerRequestDto) {
    BusinessCustomer businessCustomer =
        this.customerInitMapper.toBusinessCustomer(businessCustomerRequestDto);

    return this.customerUseCase.updateBusinessCustomer(businessCustomerId, businessCustomer);
  }

  @PutMapping("/personal/{personal-customer-id}/activate")
  public Mono<Void> activePersonalCustomer(
      @PathVariable("personal-customer-id") String personalCustomerId) {
    return this.customerUseCase.activePersonalCustomerById(personalCustomerId);
  }

  @PutMapping("/personal/{personal-customer-id}/deactivate")
  public Mono<Void> deactivatePersonalCustomer(
      @PathVariable("personal-customer-id") String personalCustomerId) {
    return this.customerUseCase.deactivatePersonalCustomerById(personalCustomerId);
  }

  @PutMapping("/business/{business-customer-id}/activate")
  public Mono<Void> activeBusinessCustomer(
      @PathVariable("business-customer-id") String businessCustomerId) {
    return this.customerUseCase.activeBusinessCustomerById(businessCustomerId);
  }

  @PutMapping("/business/{business-customer-id}/deactivate")
  public Mono<Void> deactivateBusinessCustomer(
      @PathVariable("business-customer-id") String businessCustomerId) {
    return this.customerUseCase.deactivateBusinessCustomerById(businessCustomerId);
  }
}
