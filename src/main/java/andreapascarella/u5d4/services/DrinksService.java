package andreapascarella.u5d4.services;

import andreapascarella.u5d4.entities.Drink;
import andreapascarella.u5d4.exceptions.ValidationException;
import andreapascarella.u5d4.repositories.DrinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinksService {

    private final DrinksRepository drinksRepository;

    @Autowired
    public DrinksService(DrinksRepository drinksRepository) {
        this.drinksRepository = drinksRepository;
    }

    public void saveDrink(Drink drink) {
        if (drinksRepository.existsByName(drink.getName()))
            throw new ValidationException("Drink con nome " + drink.getName() + " giá esistente");
    }
}
