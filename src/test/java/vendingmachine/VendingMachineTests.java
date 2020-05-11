package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class VendingMachineTests {
    @ParameterizedTest
    @MethodSource("params")
    void insert(Money money, int expected) {
        VendingMachine target = new VendingMachine();
        target.insert(money);

        int actual = target.displayTotalAmount();

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> params() {
        return Stream.of(
            Arguments.arguments(Money.COIN10, 10),
            Arguments.arguments(Money.COIN50, 50),
            Arguments.arguments(Money.COIN100, 100),
            Arguments.arguments(Money.COIN500, 500),
            Arguments.arguments(Money.BILL1000, 1000)
        );
    }
}
