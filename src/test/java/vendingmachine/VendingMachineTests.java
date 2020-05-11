package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VendingMachineTests {
    @Test
    void insert() {
        VendingMachine target = new VendingMachine();
        target.insert(Money.COIN10);

        int actual = target.displayTotalAmount();

        assertThat(actual).isEqualTo(10);
    }
}
