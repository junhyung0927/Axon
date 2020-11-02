package io.wisoft.axon.command.order;

import io.wisoft.axon.command.customer.CreateCustomerCommand;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final CommandGateway gateway;
    private final CustomerService service;

    @Override
    public CompletableFuture<String> createOrder(CreateOrderRequest request) {
        service.verifyCustomerId(request.getCustomerId());

        log.debug("handling {}", request.getCustomerId());

        return gateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                request.getCustomerId(),
                request.getTotalAmount()
        ));
    }
}
