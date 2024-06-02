package clone.carrot.dto;

import clone.carrot.domain.Place;
import org.springframework.web.multipart.MultipartFile;

public record SellCreateDto(
        String title,
        long cost,

        boolean costPropose,

        String detail,

        Place place,
        boolean soldOut,
        MultipartFile image
) {
}
