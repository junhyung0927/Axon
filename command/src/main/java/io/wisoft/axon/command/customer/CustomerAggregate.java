package io.wisoft.axon.command.customer;

import io.wisoft.axon.common.customer.CustomerCreatedEvent;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
@Slf4j
@Entity(name = "customer")
@Table(name = "customer")
public class CustomerAggregate {

    @AggregateIdentifier
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "holding_amount")
    private Long holdingAmount;

    @CommandHandler
    public CustomerAggregate(final CreateCustomerCommand command) {
        log.debug("handling {}", command);

        this.customerId = command.getCustomerId();
        this.customerName = command.getCustomerName();
        this.holdingAmount = command.getHoldingAmount();

        apply(new CustomerCreatedEvent(
                command.getCustomerId(),
                command.getCustomerName(),
                command.getHoldingAmount()));
    }
}
