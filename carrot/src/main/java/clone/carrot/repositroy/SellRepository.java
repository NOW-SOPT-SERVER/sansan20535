package clone.carrot.repositroy;

import clone.carrot.domain.Place;
import clone.carrot.domain.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellRepository extends JpaRepository<Sell, Long> {
    List<Sell> findSellByPlace(Place place);
}
