package com.example.customerapi.infrastructure.repository;

import com.example.customerapi.infrastructure.repository.document.BusinessCustomerDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCustomerRepository
    extends ReactiveMongoRepository<BusinessCustomerDocument, String> {}
