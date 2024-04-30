package org.sopt.practice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    POST_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 게시글이 존재하지 않습니다."),
    MEMBER_NOT_MATCH_BLOG(HttpStatus.NOT_FOUND.value(), "사용자가 보유하지 않은 블로그입니다.");

    private final int status;
    private final String message;
}
