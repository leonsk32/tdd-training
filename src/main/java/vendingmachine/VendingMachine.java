package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Money> insertedMoneys = new ArrayList<>();

    public void insert(Money money) {
        this.insertedMoneys.add(money);
    }

    public int displayTotalAmount() {
        return insertedMoneys.stream()
            .mapToInt(Money::getValue)
            .sum();
    }

    public int refund() {
        return displayTotalAmount();
    }
}
