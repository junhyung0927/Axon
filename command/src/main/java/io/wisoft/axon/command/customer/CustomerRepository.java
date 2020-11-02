package io.wisoft.axon.command.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerAggregate, String> {

    Optional<CustomerAggregate> findCustomerAggregateByCustomerId(final String customerId);

}
