package clone.carrot.controller;

import clone.carrot.domain.Customer;
import clone.carrot.dto.CustomerCreateDto;
import clone.carrot.dto.SellCreateDto;
import clone.carrot.service.CustomerService;
import clone.carrot.service.SellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity createCustomer(
            @RequestBody CustomerCreateDto customerCreateDto
    ) {
        return ResponseEntity.created(URI.create(customerService.createCustomer(customerCreateDto))).build();
    }
}
