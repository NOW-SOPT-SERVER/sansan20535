package clone.carrot.controller;

import clone.carrot.common.SuccessMesasge;
import clone.carrot.common.SuccessResponse;
import clone.carrot.domain.Place;
import clone.carrot.dto.SellCreateDto;
import clone.carrot.service.SellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sell")
public class SellController {

    private final SellService sellService;

    @PostMapping("/{customerId}")
    public ResponseEntity createSell(
            //customerId 명시 안 하면 왜 안돌아가는지
            @PathVariable("customerId") Long customerId,
            @ModelAttribute SellCreateDto sellCreateDto
    ) {
        return ResponseEntity.created(URI.create(sellService.createSell(customerId, sellCreateDto))).build();
    }

    @GetMapping("/list")
    public ResponseEntity<SuccessResponse> findSellListByPlace(
            @RequestParam("place") Place place
    ) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(SuccessResponse.of(SuccessMesasge.SELLLIST_FIND_BY_PLACE_SUCCESS, sellService.findSellListByPlace(place)));
    }

    @DeleteMapping("/{sellId}")
    public ResponseEntity deleteSell(
            //customerId 명시 안 하면 왜 안돌아가는지
            @PathVariable("sellId") Long sellId
    ) {
        sellService.deleteSell(sellId);
        return ResponseEntity.noContent().build();
    }
}
