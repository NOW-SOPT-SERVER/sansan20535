package clone.carrot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMesasge {
    SELLLIST_FIND_BY_PLACE_SUCCESS(HttpStatus.FOUND.value(), "판매 목록을 불러오는데 성공하였습니다.");

    private final int status;
    private final String message;
}
