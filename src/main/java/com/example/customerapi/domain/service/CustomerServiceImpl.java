package com.example.customerapi.domain.service;

import com.example.customerapi.domain.exception.BusinessCustomerNotFoundException;
import com.example.customerapi.domain.exception.PersonalCustomerNotFoundException;
import com.example.customerapi.domain.model.BusinessCustomer;
import com.example.customerapi.domain.model.PersonalCustomer;
import com.example.customerapi.domain.port.in.CustomerUseCase;
import com.example.customerapi.domain.port.out.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerUseCase {
  private final CustomerRepositoryPort customerRepositoryPort;

  @Override
  public Flux<PersonalCustomer> getAllPersonalCustomers() {
    return this.customerRepositoryPort.getAllPersonalCustomers();
  }

  @Override
  public Mono<PersonalCustomer> getPersonalCustomerById(String id) {
    return this.customerRepositoryPort
        .getPersonalCustomerById(id)
        .switchIfEmpty(Mono.error(new PersonalCustomerNotFoundException()));
  }

  @Override
  public Mono<BusinessCustomer> getBusinessCustomerById(String id) {
    return this.customerRepositoryPort
        .getBusinessCustomerById(id)
        .switchIfEmpty(Mono.error(new BusinessCustomerNotFoundException()));
  }

  @Override
  public Mono<Void> savePersonalCustomer(PersonalCustomer personalCustomer) {
    return this.customerRepositoryPort.savePersonalCustomer(personalCustomer);
  }

  @Override
  public Mono<Void> saveBusinessCustomer(BusinessCustomer businessCustomer) {
    return this.customerRepositoryPort.saveBusinessCustomer(businessCustomer);
  }

  @Override
  public Mono<Void> updatePersonalCustomer(String id, PersonalCustomer personalCustomer) {
    return this.customerRepositoryPort.updatePersonalCustomer(id, personalCustomer);
  }

  @Override
  public Mono<Void> updateBusinessCustomer(String id, BusinessCustomer businessCustomer) {
    return this.customerRepositoryPort.updateBusinessCustomer(id, businessCustomer);
  }

  @Override
  public Mono<Void> activePersonalCustomerById(String id) {
    return this.customerRepositoryPort.activePersonalCustomerById(id);
  }

  @Override
  public Mono<Void> deactivatePersonalCustomerById(String id) {
    return this.customerRepositoryPort.deactivatePersonalCustomerById(id);
  }

  @Override
  public Mono<Void> activeBusinessCustomerById(String id) {
    return this.customerRepositoryPort.activeBusinessCustomerById(id);
  }

  @Override
  public Mono<Void> deactivateBusinessCustomerById(String id) {
    return this.customerRepositoryPort.deactivateBusinessCustomerById(id);
  }
}
