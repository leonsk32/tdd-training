package vendingmachine;

public class VendingMachine {
    private Money money = null;

    public void insert(Money money) {
        this.money = money;
    }

    public int displayTotalAmount() {
        return money.getValue();
    }
}
