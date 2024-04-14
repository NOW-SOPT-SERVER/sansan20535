package clone.carrot.dto;

import clone.carrot.domain.Place;

public record SellCreateDto(
        String title,
        long cost,

        boolean costPropose,

        String detail,

        Place place,
        boolean soldOut
) {
}
