package io.wisoft.axon.command.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@ToString
@Getter
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String customerId;
    private Long totalAmount;

}
