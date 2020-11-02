package io.wisoft.axon.common.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class CustomerCreatedEvent {

    private String customerId;
    private String customerName;
    private Long holdingAmount;

}
