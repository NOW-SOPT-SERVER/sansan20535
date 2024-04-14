package clone.carrot.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Sell {

    // long(원시타입) 대신 Long(참조타입)을 사용하는 이유
    // Long은 null값을 가질 수 있다. -> DB에서 원하는 id가 없을 수 있기 때문
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private long cost;

    private boolean costPropose;

    private String detail;

    @Enumerated(EnumType.STRING)
    private Place place;

    @Builder
    public Sell(String title, long cost, boolean costPropose, String detail, Place place) {
        this.title = title;
        this.cost = cost;
        this.costPropose = costPropose;
        this.detail = detail;
        this.place = place;
    }


    public static Sell create(String title, long cost, boolean costPropose, String detail, Place place) {
        return Sell.builder()
                .title(title)
                .cost(cost)
                .costPropose(costPropose)
                .detail(detail)
                .place(place)
                .build();
    }
}
