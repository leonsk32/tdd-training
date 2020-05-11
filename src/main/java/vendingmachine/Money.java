package vendingmachine;

public enum Money {
    COIN10(10),
    COIN50(50);

    private int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
