package org.sopt.practice.dto;

import jakarta.validation.constraints.Size;

public record PostCreateDto(

        @Size(min = 1, max = 10, message = "최소 1글자, 최대 10글자 사이의 제목을 지어주세요.")
        String title,
        @Size(max = 100, message = "본문의 내용은 최대 100글자까지 작성하실 수 있습니다.")
        String content
) {
}
