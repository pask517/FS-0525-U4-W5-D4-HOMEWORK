package andreapascarella.u5d4.repositories;

import andreapascarella.u5d4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingsRepository extends JpaRepository<Topping, Long> {

    boolean existsByName(String name);
}
