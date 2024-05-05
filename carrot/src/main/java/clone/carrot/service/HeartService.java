package clone.carrot.service;

import clone.carrot.domain.Heart;
import clone.carrot.repositroy.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartRepository heartRepository;
    private final SellService sellService;
    private final CustomerService customerService;

    public String create(Long customerId, Long sellId) {
        Heart heart = Heart.create(customerService.findById(customerId), sellService.findById(sellId));
        heartRepository.save(heart);
        return heart.getId().toString();
    }

}
