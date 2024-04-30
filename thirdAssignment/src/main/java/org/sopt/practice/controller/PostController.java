package org.sopt.practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.common.dto.SuccessFindPostResponse;
import org.sopt.practice.common.dto.SuccessMessage;
import org.sopt.practice.common.dto.SuccessStatusResponse;
import org.sopt.practice.dto.BlogCreateRequest;
import org.sopt.practice.dto.PostCreateDto;
import org.sopt.practice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader("blogId") Long blogId,
            @RequestHeader("memberId") Long memberId,
            @Valid @RequestBody PostCreateDto postCreateDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", postService.create(blogId, memberId, postCreateDto))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<SuccessFindPostResponse> findPost(
            @PathVariable("postId") Long postId
    ) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(SuccessFindPostResponse.of(postService.findById(postId), SuccessMessage.POST_FIND_SUCCESS));
    }
}
