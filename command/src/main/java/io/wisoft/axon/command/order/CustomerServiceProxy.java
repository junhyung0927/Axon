package io.wisoft.axon.command.order;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class CustomerServiceProxy implements CustomerService{

    private final RestTemplate restTemplate;

    @Value("http://localhost:8090/customers/{customerId}")
    private String customerServiceUrl;

    @Override
    public void verifyCustomerId(String customerId) {
        try{
            restTemplate.getForEntity(customerServiceUrl, Customer.class, customerId);
        } catch (HttpClientErrorException e){
            throw new CustomerNotFoundException();
        }
    }
}
