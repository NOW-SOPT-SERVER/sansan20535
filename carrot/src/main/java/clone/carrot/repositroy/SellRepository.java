package clone.carrot.repositroy;

import clone.carrot.domain.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
