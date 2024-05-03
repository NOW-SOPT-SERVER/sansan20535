package clone.carrot.common;

import clone.carrot.dto.SellFindDto;

import java.util.List;

public record SuccessResponse<T>(
        int status,
        String message,

        List<T> data
) {

    public static SuccessResponse<SellFindDto> of(SuccessMesasge successMesasge, List<SellFindDto> sellFindDtoList) {
        return new SuccessResponse<SellFindDto>(successMesasge.getStatus(), successMesasge.getMessage(), sellFindDtoList);
    }
}
