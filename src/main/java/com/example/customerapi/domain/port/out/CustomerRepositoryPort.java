package com.example.customerapi.domain.port.out;

import com.example.customerapi.domain.model.BusinessCustomer;
import com.example.customerapi.domain.model.PersonalCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepositoryPort {
  Flux<PersonalCustomer> getAllPersonalCustomers();

  Mono<PersonalCustomer> getPersonalCustomerById(String id);

  Mono<BusinessCustomer> getBusinessCustomerById(String id);

  Mono<Void> savePersonalCustomer(PersonalCustomer personalCustomer);

  Mono<Void> saveBusinessCustomer(BusinessCustomer businessCustomer);

  Mono<Void> updatePersonalCustomer(String id, PersonalCustomer personalCustomer);

  Mono<Void> updateBusinessCustomer(String id, BusinessCustomer businessCustomer);

  Mono<Void> activePersonalCustomerById(String id);

  Mono<Void> deactivatePersonalCustomerById(String id);

  Mono<Void> activeBusinessCustomerById(String id);

  Mono<Void> deactivateBusinessCustomerById(String id);
}
