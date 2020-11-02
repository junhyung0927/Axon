package io.wisoft.axon.command.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerRequest request){
        return customerService.createCustomer(request);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerAggregate> getCustomer(@PathVariable final String customerId){
        Optional<CustomerAggregate> aggregate = customerService.findById(customerId);
        if(aggregate.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(aggregate.get(), HttpStatus.OK);
    }
}
