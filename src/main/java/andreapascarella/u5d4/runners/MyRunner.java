package andreapascarella.u5d4.runners;

import andreapascarella.u5d4.entities.Drink;
import andreapascarella.u5d4.entities.Pizza;
import andreapascarella.u5d4.entities.Topping;
import andreapascarella.u5d4.services.DrinksService;
import andreapascarella.u5d4.services.PizzasService;
import andreapascarella.u5d4.services.ToppingsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class MyRunner implements CommandLineRunner {

    private final PizzasService pizzasService;

    private final DrinksService drinksService;

    private final ToppingsService toppingsService;

    @Override
    public void run(String... args) throws Exception {

        Topping tomato = new Topping("Tomato", 100, 0.50);
        Topping cheese = new Topping("Cheese", 120, 0.50);
        Topping ham = new Topping("Ham", 150, 1.20);

        //toppingsService.saveTopping(tomato);
        //toppingsService.saveTopping(cheese);
        //toppingsService.saveTopping(ham);

        Pizza margherita = new Pizza("Margherita", List.of(toppingsService.findToppingById(1), toppingsService.findToppingById(2)), false);
        Pizza margheritaConProsciutto = new Pizza("Margherita con prosciutto", List.of(toppingsService.findToppingById(1), toppingsService.findToppingById(2), toppingsService.findToppingById(52)), true);

        //pizzasService.savePizza(margherita);
        //pizzasService.savePizza(margheritaConProsciutto);

        Drink lemonade = new Drink("Lemonade", 50, 2.20);
        //drinksService.saveDrink(lemonade);

        pizzasService.filterByNameContaining("prosciutto").forEach(System.out::println);


    }
}

