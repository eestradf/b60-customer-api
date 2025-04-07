package com.example.customerapi.infrastructure.repository.mapper;

import com.example.customerapi.domain.model.BusinessCustomer;
import com.example.customerapi.domain.model.CustomerType;
import com.example.customerapi.domain.model.PersonalCustomer;
import com.example.customerapi.infrastructure.repository.document.BusinessCustomerDocument;
import com.example.customerapi.infrastructure.repository.document.PersonalCustomerDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "email", source = "contactInfo.email")
  @Mapping(target = "phone", source = "contactInfo.phone")
  @Mapping(target = "country", source = "contactInfo.address.country")
  @Mapping(target = "province", source = "contactInfo.address.province")
  @Mapping(target = "district", source = "contactInfo.address.district")
  @Mapping(target = "postalCode", source = "contactInfo.address.postalCode")
  @Mapping(target = "birthDate", source = "birthDate")
  @Mapping(target = "identificationNumber", source = "identificationNumber")
  @Mapping(target = "isActive", source = "isActive")
  PersonalCustomerDocument toPersonalCustomerDocument(PersonalCustomer personalCustomer);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "email", source = "contactInfo.email")
  @Mapping(target = "phone", source = "contactInfo.phone")
  @Mapping(target = "country", source = "contactInfo.address.country")
  @Mapping(target = "province", source = "contactInfo.address.province")
  @Mapping(target = "district", source = "contactInfo.address.district")
  @Mapping(target = "postalCode", source = "contactInfo.address.postalCode")
  @Mapping(target = "companyRegistrationNumber", source = "companyRegistrationNumber")
  @Mapping(target = "companyNumber", source = "companyNumber")
  @Mapping(target = "isActive", source = "isActive")
  BusinessCustomerDocument toBusinessCustomerDocument(BusinessCustomer businessCustomer);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "contactInfo.email", source = "email")
  @Mapping(target = "contactInfo.phone", source = "phone")
  @Mapping(target = "contactInfo.address.country", source = "country")
  @Mapping(target = "contactInfo.address.province", source = "province")
  @Mapping(target = "contactInfo.address.district", source = "district")
  @Mapping(target = "contactInfo.address.postalCode", source = "postalCode")
  @Mapping(target = "birthDate", source = "birthDate")
  @Mapping(target = "identificationNumber", source = "identificationNumber")
  @Mapping(target = "isActive", source = "isActive")
  PersonalCustomer toPersonalCustomer(PersonalCustomerDocument personalCustomerDocument);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "contactInfo.email", source = "email")
  @Mapping(target = "contactInfo.phone", source = "phone")
  @Mapping(target = "contactInfo.address.country", source = "country")
  @Mapping(target = "contactInfo.address.province", source = "province")
  @Mapping(target = "contactInfo.address.district", source = "district")
  @Mapping(target = "contactInfo.address.postalCode", source = "postalCode")
  @Mapping(target = "companyRegistrationNumber", source = "companyRegistrationNumber")
  @Mapping(target = "companyNumber", source = "companyNumber")
  @Mapping(target = "isActive", source = "isActive")
  BusinessCustomer toBusinessCustomer(BusinessCustomerDocument businessCustomerDocument);

  default String customerTypeToString(CustomerType customerType) {
    if (customerType == null) {
      return null;
    }
    return customerType.name();
  }

  default CustomerType stringToCustomerType(String customerType) {
    if (customerType == null) {
      return null;
    }
    return CustomerType.valueOf(customerType.toUpperCase());
  }
}
