package com.example.customerapi.application.mapper;

import com.example.customerapi.application.dto.BusinessCustomerRequestDto;
import com.example.customerapi.application.dto.BusinessCustomerResponseDto;
import com.example.customerapi.application.dto.PersonalCustomerRequestDto;
import com.example.customerapi.application.dto.PersonalCustomerResponseDto;
import com.example.customerapi.domain.model.BusinessCustomer;
import com.example.customerapi.domain.model.PersonalCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerInitMapper {

  @Mapping(target = "id", ignore = true)
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
  PersonalCustomer toPersonalCustomer(PersonalCustomerRequestDto personalCustomerRequestDto);

  @Mapping(target = "id", ignore = true)
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
  BusinessCustomer toBusinessCustomer(BusinessCustomerRequestDto businessCustomerRequestDto);

  PersonalCustomerResponseDto toPersonalCustomerResponseDto(PersonalCustomer personalCustomer);

  BusinessCustomerResponseDto toBusinessCustomerResponseDto(BusinessCustomer businessCustomer);
}
