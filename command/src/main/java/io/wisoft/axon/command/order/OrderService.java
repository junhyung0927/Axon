package io.wisoft.axon.command.order;

import java.util.concurrent.CompletableFuture;

public interface OrderService {
    CompletableFuture<String> createOrder(final CreateOrderRequest request);
}
