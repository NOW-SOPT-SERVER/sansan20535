package org.sopt.practice.dto;

public record UserJoinResponse(
        String accessToken,
        String userId,
        String refreshToken
) {

    public static UserJoinResponse of(
            String accessToken,
            String userId,
            String refreshToken
    ) {
        return new UserJoinResponse(accessToken, userId, refreshToken);
    }
}

