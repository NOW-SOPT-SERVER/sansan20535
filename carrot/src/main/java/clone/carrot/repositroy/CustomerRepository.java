package clone.carrot.repositroy;

import clone.carrot.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
