package io.wisoft.axon.command.customer;

import java.util.concurrent.CompletableFuture;

public interface CustomerService {

    CompletableFuture<String> createCustomer(final CreateCustomerRequest request);

}
