package andreapascarella.u5d4.repositories;

import andreapascarella.u5d4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinksRepository extends JpaRepository<Drink, Long> {

    boolean existsByName(String name);

}
