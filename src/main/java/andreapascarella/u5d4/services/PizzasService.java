package andreapascarella.u5d4.services;

import andreapascarella.u5d4.entities.Pizza;
import andreapascarella.u5d4.exceptions.ValidationException;
import andreapascarella.u5d4.repositories.PizzasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PizzasService {

    private final PizzasRepository pizzasRepository;


    @Autowired
    public PizzasService(PizzasRepository pizzasRepository, ToppingsService toppingsService) {
        this.pizzasRepository = pizzasRepository;
    }

    public void savePizza(Pizza pizza) {
        if (pizzasRepository.existsByName(pizza.getName()))
            throw new ValidationException("Pizza con nome " + pizza.getName() + " giá esistente");

        this.pizzasRepository.save(pizza);
    }

    public Pizza filterByNameLike(String partialName) {
        return (Pizza) pizzasRepository.findByNameLike(partialName);
    }

}
