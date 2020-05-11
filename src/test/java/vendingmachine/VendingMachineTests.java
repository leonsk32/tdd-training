package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VendingMachineTests {
    @Test
    void insert10() {
        VendingMachine target = new VendingMachine();
        target.insert(Money.COIN10);

        int actual = target.displayTotalAmount();

        assertThat(actual).isEqualTo(10);
    }

    @Test
    void insert50() {
        VendingMachine target = new VendingMachine();
        target.insert(Money.COIN50);

        int actual = target.displayTotalAmount();

        assertThat(actual).isEqualTo(50);
    }
}
