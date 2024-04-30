package org.sopt.practice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.practice.dto.PostCreateDto;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    public Post(String title, String content, Blog blog) {
        this.title = title;
        this.content = content;
        this.blog = blog;
    }

    public static Post create(Blog blog, PostCreateDto postCreateDto) {
        return new Post(postCreateDto.title(), postCreateDto.content(), blog);
    }
}
