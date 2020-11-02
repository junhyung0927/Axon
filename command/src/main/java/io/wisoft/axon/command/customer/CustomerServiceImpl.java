package io.wisoft.axon.command.customer;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CommandGateway gateway;
    private final CustomerRepository repository;

    @Override
    public CompletableFuture<String> createCustomer(CreateCustomerRequest request) {
        return this.gateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                request.getCustomerName(),
                request.getHoldingAmount()
        ));
    }

    @Override
    public Optional<CustomerAggregate> findById(String customerId) {
        return repository.findById(customerId);
    }
}
