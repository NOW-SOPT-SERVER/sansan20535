package org.sopt.practice.dto;

import java.sql.Ref;

public record RefreshTokenResponse(
        String accessToken,
        String refreshToken
) {
    public static RefreshTokenResponse of(
            String accessToken,
            String refreshToken
    ) {
        return new RefreshTokenResponse(accessToken, refreshToken);
    }
}
