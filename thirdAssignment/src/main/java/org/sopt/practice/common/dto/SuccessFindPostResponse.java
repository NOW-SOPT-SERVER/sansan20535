package org.sopt.practice.common.dto;

import org.sopt.practice.domain.Post;
import org.sopt.practice.dto.PostFindDto;

public record SuccessFindPostResponse(
        int status,
        String message,
        PostFindDto data
) {
    public static SuccessFindPostResponse of(PostFindDto postFindDto,SuccessMessage successMessage) {
        return new SuccessFindPostResponse(successMessage.getStatus(), successMessage.getMessage(), postFindDto);
    }
}
