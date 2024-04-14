package clone.carrot.controller;

import clone.carrot.dto.SellCreateDto;
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
@RequestMapping("/api/v1/sell")
public class SellController {

    private final SellService sellService;

    @PostMapping
    public ResponseEntity createSell(
            @RequestBody SellCreateDto sellCreateDto
            ){
        return ResponseEntity.created(URI.create(sellService.createSell(sellCreateDto))).build();
    }
}
