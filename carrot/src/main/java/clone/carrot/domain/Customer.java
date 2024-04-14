package clone.carrot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String nickname;

    @Builder
    public Customer(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public static Customer create(String name, String nickname) {
        return Customer.builder()
                .name(name)
                .nickname(nickname)
                .build();
    }
}
