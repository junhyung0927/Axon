package io.wisoft.axon.common.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class OrderCreatedEvent {

    private String orderId;
    private String customerId;
    private Long totalAmount;

}
