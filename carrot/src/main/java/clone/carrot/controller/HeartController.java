package clone.carrot.controller;

import clone.carrot.common.SuccessMesasge;
import clone.carrot.common.SuccessResponse;
import clone.carrot.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like")
public class HeartController {

    private final HeartService heartService;

    @Transactional
    @PostMapping
    public ResponseEntity<SuccessResponse> createLike(
        @RequestHeader("customerId") Long customerId,
        @RequestHeader("sellId") Long sellId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", heartService.create(customerId, sellId))
                .body(SuccessResponse.of(SuccessMesasge.HEART_CREATE_SUCCESS));
    }
}
