package work4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liquid {
    String name;
    int weight;
    int totalPrice;
    int price;

    public Liquid(String name, int i, int i1) {
        this.name=name;
        this.weight=i;
        this.totalPrice=i1;
        this.price=i1/i;
    }
}
