package clone.carrot.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.lang.reflect.Member;

@Getter
@NoArgsConstructor
@Entity
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sell sell;

    @Builder
    public Heart(Customer customer, Sell sell) {
        this.customer = customer;
        this.sell = sell;
    }

    public static Heart create(Customer customer, Sell sell) {
        return Heart.builder()
                .customer(customer)
                .sell(sell)
                .build();
    }
}
