package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Money> insertedMoneys = new ArrayList<>();

    public int insert(Money money) {
        if (money == Money.COIN1) {
            return 1;
        }

        this.insertedMoneys.add(money);
        return 0;
    }

    public String displayTotalAmount() {
        return String.valueOf(getSum());
    }

    public int refund() {
        return getSum();
    }

    private int getSum() {
        return insertedMoneys.stream()
            .mapToInt(Money::getValue)
            .sum();
    }
}
