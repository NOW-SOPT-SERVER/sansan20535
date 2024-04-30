package org.sopt.practice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.practice.dto.BlogCreateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    private Blog(Member member, String title, String description){
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(Member member, BlogCreateRequest blogCreateRequest) {
        return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
    }

    //이 부분 여기 Blog에 쓰는 게 맞는 지
    public void updateTitle(
            String title
    ) {
        this.title = title;
    }
}
