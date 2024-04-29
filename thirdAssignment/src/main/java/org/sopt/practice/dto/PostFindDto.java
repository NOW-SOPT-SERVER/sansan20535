package org.sopt.practice.dto;

import org.sopt.practice.domain.Post;

public record PostFindDto(
        String title,
        String content
) {
    public static PostFindDto of(Post post) {
        return new PostFindDto(post.getTitle(), post.getContent());
    }
}
