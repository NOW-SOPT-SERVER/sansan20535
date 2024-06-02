package clone.carrot.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
public class Sell {

    // long(원시타입) 대신 Long(참조타입)을 사용하는 이유
    // Long은 null값을 가질 수 있다. -> DB에서 원하는 id가 없을 수 있기 때문
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickname;

    private String title;

    private long cost;

    private boolean costPropose;

    private String detail;

    @Enumerated(EnumType.STRING)
    private Place place;

    private boolean soldOut;

    @ColumnDefault("0")
    private long likeCount;

    private String imageUrl;

    @Builder
    public Sell(String nickname, String title, long cost, boolean costPropose, String detail, Place place, boolean soldOut, String imageUrl) {
        this.nickname = nickname;
        this.title = title;
        this.cost = cost;
        this.costPropose = costPropose;
        this.detail = detail;
        this.place = place;
        this.soldOut = soldOut;
        this.imageUrl = imageUrl;
    }


    public static Sell create(String nickname, String title, long cost, boolean costPropose, String detail, Place place, boolean soldOut, String imageUrl) {
        return Sell.builder()
                .nickname(nickname)
                .title(title)
                .cost(cost)
                .costPropose(costPropose)
                .detail(detail)
                .place(place)
                .soldOut(soldOut)
                .imageUrl(imageUrl)
                .build();
    }
}
