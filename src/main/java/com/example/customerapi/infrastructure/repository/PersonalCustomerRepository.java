package com.example.customerapi.infrastructure.repository;

import com.example.customerapi.infrastructure.repository.document.PersonalCustomerDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCustomerRepository
    extends ReactiveMongoRepository<PersonalCustomerDocument, String> {}
