package io.wisoft.axon.command.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@ToString
@Getter
public class CreateCustomerCommand {

    @TargetAggregateIdentifier
    private String customerId;
    private String customerName;
    private Long holdingAmount;
}
