package andreapascarella.u5d4.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Item {

    @Column(nullable = false)
    protected int calories;
    @Column(nullable = false)
    protected double price;
    @Column(nullable = false)
    protected String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;

    public Item(int calories, double price, String name) {
        this.calories = calories;
        this.price = price;
        this.name = name;
    }

}
