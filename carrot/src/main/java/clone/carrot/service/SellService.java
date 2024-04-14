package clone.carrot.service;

import clone.carrot.domain.Customer;
import clone.carrot.domain.Sell;
import clone.carrot.dto.SellCreateDto;
import clone.carrot.repositroy.CustomerRepository;
import clone.carrot.repositroy.SellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellService {

    private final SellRepository sellRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public String createSell(
            Long customerId, SellCreateDto sellCreateDto
    ) {
        //orElseThrow()를 안 붙이면 실행이 안되는 이유
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Sell sell = Sell.create(customer.getNickname(), sellCreateDto.title(), sellCreateDto.cost(), sellCreateDto.costPropose(), sellCreateDto.detail(), sellCreateDto.place(), sellCreateDto.soldOut());
        sellRepository.save(sell);
        return sell.getId().toString();
    }
}
