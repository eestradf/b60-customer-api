package com.example.customerapi.infrastructure.adapter;

import com.example.customerapi.domain.exception.BusinessCustomerNotFoundException;
import com.example.customerapi.domain.exception.PersonalCustomerNotFoundException;
import com.example.customerapi.domain.model.BusinessCustomer;
import com.example.customerapi.domain.model.PersonalCustomer;
import com.example.customerapi.domain.port.out.CustomerRepositoryPort;
import com.example.customerapi.infrastructure.repository.BusinessCustomerRepository;
import com.example.customerapi.infrastructure.repository.PersonalCustomerRepository;
import com.example.customerapi.infrastructure.repository.document.BusinessCustomerDocument;
import com.example.customerapi.infrastructure.repository.document.PersonalCustomerDocument;
import com.example.customerapi.infrastructure.repository.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerRepositoryPort {
  private final PersonalCustomerRepository personalCustomerRepository;
  private final BusinessCustomerRepository businessCustomerRepository;
  private final CustomerMapper customerMapper;

  @Override
  public Flux<PersonalCustomer> getAllPersonalCustomers() {
    return this.personalCustomerRepository.findAll().map(this.customerMapper::toPersonalCustomer);
  }

  @Override
  public Mono<PersonalCustomer> getPersonalCustomerById(String id) {
    return this.personalCustomerRepository
        .findById(id)
        .map(this.customerMapper::toPersonalCustomer);
  }

  @Override
  public Mono<BusinessCustomer> getBusinessCustomerById(String id) {
    return this.businessCustomerRepository
        .findById(id)
        .map(this.customerMapper::toBusinessCustomer);
  }

  @Override
  public Mono<Void> savePersonalCustomer(PersonalCustomer personalCustomer) {
    PersonalCustomerDocument personalCustomerDocument =
        this.customerMapper.toPersonalCustomerDocument(personalCustomer);
    personalCustomerDocument.setIsActive(Boolean.TRUE);

    return this.personalCustomerRepository.save(personalCustomerDocument).then();
  }

  @Override
  public Mono<Void> saveBusinessCustomer(BusinessCustomer businessCustomer) {
    BusinessCustomerDocument businessCustomerDocument =
        this.customerMapper.toBusinessCustomerDocument(businessCustomer);
    businessCustomerDocument.setIsActive(Boolean.TRUE);

    return this.businessCustomerRepository.save(businessCustomerDocument).then();
  }

  @Override
  public Mono<Void> updatePersonalCustomer(String id, PersonalCustomer personalCustomer) {
    return this.personalCustomerRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new PersonalCustomerNotFoundException()))
        .map(
            existingPersonalCustomerDocument -> {
              existingPersonalCustomerDocument.setName(personalCustomer.getName());
              existingPersonalCustomerDocument.setCustomerType(
                  personalCustomer.getCustomerType().name());
              existingPersonalCustomerDocument.setEmail(
                  personalCustomer.getContactInfo().getEmail());
              existingPersonalCustomerDocument.setPhone(
                  personalCustomer.getContactInfo().getPhone());
              existingPersonalCustomerDocument.setCountry(
                  personalCustomer.getContactInfo().getAddress().getCountry());
              existingPersonalCustomerDocument.setProvince(
                  personalCustomer.getContactInfo().getAddress().getProvince());
              existingPersonalCustomerDocument.setDistrict(
                  personalCustomer.getContactInfo().getAddress().getDistrict());
              existingPersonalCustomerDocument.setPostalCode(
                  personalCustomer.getContactInfo().getAddress().getPostalCode());
              existingPersonalCustomerDocument.setBirthDate(personalCustomer.getBirthDate());
              existingPersonalCustomerDocument.setIdentificationNumber(
                  personalCustomer.getIdentificationNumber());

              return existingPersonalCustomerDocument;
            })
        .flatMap(this.personalCustomerRepository::save)
        .then();
  }

  @Override
  public Mono<Void> updateBusinessCustomer(String id, BusinessCustomer businessCustomer) {
    return this.businessCustomerRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new BusinessCustomerNotFoundException()))
        .map(
            existingBusinessCustomerDocument -> {
              existingBusinessCustomerDocument.setName(businessCustomer.getName());
              existingBusinessCustomerDocument.setCustomerType(
                  businessCustomer.getCustomerType().name());
              existingBusinessCustomerDocument.setEmail(
                  businessCustomer.getContactInfo().getEmail());
              existingBusinessCustomerDocument.setPhone(
                  businessCustomer.getContactInfo().getPhone());
              existingBusinessCustomerDocument.setCountry(
                  businessCustomer.getContactInfo().getAddress().getCountry());
              existingBusinessCustomerDocument.setProvince(
                  businessCustomer.getContactInfo().getAddress().getProvince());
              existingBusinessCustomerDocument.setDistrict(
                  businessCustomer.getContactInfo().getAddress().getDistrict());
              existingBusinessCustomerDocument.setPostalCode(
                  businessCustomer.getContactInfo().getAddress().getPostalCode());
              existingBusinessCustomerDocument.setCompanyNumber(
                  businessCustomer.getCompanyNumber());
              existingBusinessCustomerDocument.setCompanyRegistrationNumber(
                  businessCustomer.getCompanyRegistrationNumber());

              return existingBusinessCustomerDocument;
            })
        .flatMap(this.businessCustomerRepository::save)
        .then();
  }

  @Override
  public Mono<Void> activePersonalCustomerById(String id) {
    return this.personalCustomerRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new PersonalCustomerNotFoundException()))
        .map(
            existingPersonalCustomerDocument -> {
              existingPersonalCustomerDocument.setIsActive(Boolean.TRUE);

              return existingPersonalCustomerDocument;
            })
        .flatMap(this.personalCustomerRepository::save)
        .then();
  }

  @Override
  public Mono<Void> deactivatePersonalCustomerById(String id) {
    return this.personalCustomerRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new PersonalCustomerNotFoundException()))
        .map(
            existingPersonalCustomerDocument -> {
              existingPersonalCustomerDocument.setIsActive(Boolean.FALSE);

              return existingPersonalCustomerDocument;
            })
        .flatMap(this.personalCustomerRepository::save)
        .then();
  }

  @Override
  public Mono<Void> activeBusinessCustomerById(String id) {
    return this.businessCustomerRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new BusinessCustomerNotFoundException()))
        .map(
            existingBusinessCustomerDocument -> {
              existingBusinessCustomerDocument.setIsActive(Boolean.TRUE);

              return existingBusinessCustomerDocument;
            })
        .flatMap(this.businessCustomerRepository::save)
        .then();
  }

  @Override
  public Mono<Void> deactivateBusinessCustomerById(String id) {
    return this.businessCustomerRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new BusinessCustomerNotFoundException()))
        .map(
            existingBusinessCustomerDocument -> {
              existingBusinessCustomerDocument.setIsActive(Boolean.FALSE);

              return existingBusinessCustomerDocument;
            })
        .flatMap(this.businessCustomerRepository::save)
        .then();
  }
}
