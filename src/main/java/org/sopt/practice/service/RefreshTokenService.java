package org.sopt.practice.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.auth.UserAuthentication;
import org.sopt.practice.auth.redis.domain.Token;
import org.sopt.practice.auth.redis.repository.RedisTokenRepository;
import org.sopt.practice.common.dto.ErrorMessage;
import org.sopt.practice.common.jwt.JwtTokenProvider;
import org.sopt.practice.dto.RefreshTokenResponse;
import org.sopt.practice.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RedisTokenRepository redisTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public RefreshTokenResponse regenerateAccessToken(String refreshToken) {
        //refresh Token에서 bearer을 제외한 나머지 진짜 refreshToken이용
        Token token = redisTokenRepository.findByRefreshToken(refreshToken.substring("Bearer ".length())).orElseThrow(
                () -> new NotFoundException(ErrorMessage.JWT_UNAUTHORIZED_EXCEPTION)
        );
        String reIssueToken = jwtTokenProvider.issueRefreshToken(UserAuthentication.createUserAuthentication(token.getId()));
        redisTokenRepository.save(Token.of(token.getId(), reIssueToken));
        return RefreshTokenResponse.of(
                jwtTokenProvider.issueAccessToken(UserAuthentication.createUserAuthentication(token.getId())),
                reIssueToken
        );
    }
}
// refreshToken 토큰도 함께 발급할 수 있도록 수정
// redis에서도 수정 필요 새 refreshToken 필요 => 아하!
// refresh token rotation
// ex : 14일동안 유저 접속 X -> 재로그인
// 14일 사이에 접속 -> 재로그인 X