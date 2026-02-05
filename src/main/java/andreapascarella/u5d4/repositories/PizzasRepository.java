package andreapascarella.u5d4.repositories;

import andreapascarella.u5d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzasRepository extends JpaRepository<Pizza, Long> {

    boolean existsByName(String name);

    List<Pizza> findByNameLike(String name);
}
