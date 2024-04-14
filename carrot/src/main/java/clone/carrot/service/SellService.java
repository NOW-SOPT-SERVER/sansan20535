package clone.carrot.service;

import clone.carrot.domain.Sell;
import clone.carrot.dto.SellCreateDto;
import clone.carrot.repositroy.SellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellService {

    private final SellRepository sellRepository;

    @Transactional
    public String createSell(
            SellCreateDto sellCreateDto
    ){
        Sell sell = Sell.create(sellCreateDto.title(), sellCreateDto.cost(), sellCreateDto.costPropose(), sellCreateDto.detail(), sellCreateDto.place());
        sellRepository.save(sell);
        return sell.getId().toString();
    }
}
