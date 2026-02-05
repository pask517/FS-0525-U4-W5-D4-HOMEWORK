package andreapascarella.u5d4.services;


import andreapascarella.u5d4.entities.Topping;
import andreapascarella.u5d4.exceptions.NotFoundException;
import andreapascarella.u5d4.exceptions.ValidationException;
import andreapascarella.u5d4.repositories.ToppingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ToppingsService {

    private final ToppingsRepository toppingsRepository;

    @Autowired
    public ToppingsService(ToppingsRepository toppingsRepository) {
        this.toppingsRepository = toppingsRepository;
    }

    public void saveTopping(Topping topping) {
        if (toppingsRepository.existsByName(topping.getName()))
            throw new ValidationException("Topping con nome " + topping.getName() + " giá esistente");

        this.toppingsRepository.save(topping);
    }

    public Topping findToppingById(long toppingId) {
        return toppingsRepository.findById(toppingId).orElseThrow(() -> new NotFoundException(toppingId));
    }
}
