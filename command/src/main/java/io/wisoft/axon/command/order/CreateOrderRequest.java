package io.wisoft.axon.command.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateOrderRequest {

    private String customerId;
    private Long totalAmount;

}
