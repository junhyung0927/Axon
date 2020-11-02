package io.wisoft.axon.command.order;

import io.wisoft.axon.command.customer.CreateCustomerCommand;
import io.wisoft.axon.common.order.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@AllArgsConstructor
@NoArgsConstructor
@Aggregate
@Slf4j
@Entity(name = "orders")
@Table(name = "orders")
public class OrderAggregate {
    @AggregateIdentifier
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "total_amount")
    private Long totalamount;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        log.debug("handling {}", command);

        this.orderId = command.getOrderId();
        this.customerId = command.getCustomerId();
        this.totalamount = command.getTotalAmount();

        apply(new OrderCreatedEvent(
                command.getOrderId(),
                command.getCustomerId(),
                command.getTotalAmount()
        ));
    }
}
