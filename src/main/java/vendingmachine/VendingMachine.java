package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private List<Money> insertedMoneys = new ArrayList<>();
    private List<Money> validMoneys = Arrays.asList(
        Money.COIN10, Money.COIN50, Money.COIN100, Money.COIN500, Money.BILL1000
    );

    public int insert(Money money) {
        if (!validMoneys.contains(money)) {
            return money.getValue();
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
