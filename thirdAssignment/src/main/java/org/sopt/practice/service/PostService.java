package org.sopt.practice.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.common.dto.ErrorMessage;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Post;
import org.sopt.practice.dto.PostCreateDto;
import org.sopt.practice.dto.PostFindDto;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogService blogService;

    @Transactional
    public String create(Long blogId, PostCreateDto postCreateDto) {
        Blog blog = blogService.findBlogById(blogId);
        Post post = postRepository.save(Post.create(blog, postCreateDto));
        return post.getId().toString();
    }

    public PostFindDto findById(Long postId) {
        return PostFindDto.of(postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION)
        ));
    }
}
