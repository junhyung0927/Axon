package io.wisoft.axon.command.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    private String customerName;
    private Long holdingAmount;
}
