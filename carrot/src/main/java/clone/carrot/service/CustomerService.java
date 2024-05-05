package clone.carrot.service;

import clone.carrot.domain.Customer;
import clone.carrot.domain.Sell;
import clone.carrot.dto.CustomerCreateDto;
import clone.carrot.dto.SellCreateDto;
import clone.carrot.repositroy.CustomerRepository;
import clone.carrot.repositroy.SellRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public String createCustomer(
            CustomerCreateDto customerCreateDto
    ) {
        Customer customer = Customer.create(customerCreateDto.name(), customerCreateDto.nickname());
        customerRepository.save(customer);
        return customer.getId().toString();
    }

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(
                ()-> new EntityNotFoundException("Id에 해당하는 고객이 없습니다.")
        );
    }
}
