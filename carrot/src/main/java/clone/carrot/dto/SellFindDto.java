package clone.carrot.dto;

import clone.carrot.domain.Place;
import clone.carrot.domain.Sell;

public record SellFindDto(
        String nickname,
        String title,
        long cost,
        boolean costPropose,
        String detail,
        Place place,
        boolean soldOUt
) {

    public static SellFindDto of(Sell sell) {
        return new SellFindDto(sell.getNickname(), sell.getTitle(), sell.getCost(), sell.isCostPropose(), sell.getDetail(), sell.getPlace(), sell.isSoldOut());
    }
}
