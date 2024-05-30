package org.sopt.practice.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.sopt.practice.dto.RefreshTokenResponse;
import org.sopt.practice.dto.UserJoinResponse;
import org.sopt.practice.service.MemberService;
import org.sopt.practice.service.RefreshTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RefreshTokenController {

    private final RefreshTokenService refreshTokenService;

    @GetMapping("/refreshToken")
    public ResponseEntity<RefreshTokenResponse> regenerateAccessToken(
            //reissueAccessToken은 Authorization 헤더에 refreshToken만 넘기면 됨
            @RequestHeader("Authorization")String refreshToken //Bearer 붙은 상태의 refresh토큰을 넘김
            ) {
        RefreshTokenResponse refreshTokenResponse = refreshTokenService.regenerateAccessToken(refreshToken);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        refreshTokenResponse
                );
    }
}
