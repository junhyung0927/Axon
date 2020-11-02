package io.wisoft.axon.command.customer;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CustomerService {

    CompletableFuture<String> createCustomer(final CreateCustomerRequest request);

    Optional<CustomerAggregate> findById(final String customerId);


}
