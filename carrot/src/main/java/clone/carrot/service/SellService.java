package clone.carrot.service;

import clone.carrot.domain.Customer;
import clone.carrot.domain.Place;
import clone.carrot.domain.Sell;
import clone.carrot.dto.SellCreateDto;
import clone.carrot.dto.SellFindDto;
import clone.carrot.external.S3Service;
import clone.carrot.repositroy.CustomerRepository;
import clone.carrot.repositroy.SellRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellService {

    private final SellRepository sellRepository;
    private final CustomerRepository customerRepository;
    private final S3Service s3Service;
    private static final String SELL_S3_UPLOAD_FOLDER = "sell/";

    @Transactional
    public String createSell(
            Long customerId, SellCreateDto sellCreateDto
    ) {
        //orElseThrow()를 안 붙이면 실행이 안되는 이유
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new EntityNotFoundException("해당 고객님을 찾을 수 없습니다.")
        );
        try {
            Sell sell = Sell.create(customer.getNickname(), sellCreateDto.title(), sellCreateDto.cost(), sellCreateDto.costPropose(), sellCreateDto.detail(), sellCreateDto.place(), sellCreateDto.soldOut()
                    , s3Service.uploadImage(SELL_S3_UPLOAD_FOLDER, sellCreateDto.image()));
            sellRepository.save(sell);
            return sell.getId().toString();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public List<SellFindDto> findSellListByPlace(Place place) {
        List<Sell> sellList = sellRepository.findSellByPlace(place);
        List<SellFindDto> sellFindDtoList = sellList.stream().map(SellFindDto::of).toList();
        return sellFindDtoList;
    }

    public Sell findById(Long sellId) {
        return sellRepository.findById(sellId).orElseThrow(
                () -> new EntityNotFoundException("Id에 해당하는 판매 목록을 찾을 수 없습니다.")
        );
    }

    @Transactional
    public void deleteSell(Long sellId) {
        Sell sell = findById(sellId);
        try {
            s3Service.deleteImage(sell.getImageUrl());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        sellRepository.delete(sell);
    }
}
