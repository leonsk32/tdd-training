package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class VendingMachineTests {
    private VendingMachine target;

    @BeforeEach
    void setUp() {
        target = new VendingMachine();
    }

    @ParameterizedTest
    @MethodSource("params")
    void insert(Money money, String expected) {
        int change = target.insert(money);

        String actual = target.displayTotalAmount();

        assertThat(change).isEqualTo(0);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> params() {
        return Stream.of(
            Arguments.arguments(Money.COIN10, "10"),
            Arguments.arguments(Money.COIN50, "50"),
            Arguments.arguments(Money.COIN100, "100"),
            Arguments.arguments(Money.COIN500, "500"),
            Arguments.arguments(Money.BILL1000, "1000")
        );
    }

    @Test
    void insertManyTimes() {
        target.insert(Money.COIN10);
        target.insert(Money.COIN10);
        target.insert(Money.COIN50);

        String actual = target.displayTotalAmount();

        assertThat(actual).isEqualTo("70");
    }

    @Test
    void refund() {
        target.insert(Money.COIN100);
        target.insert(Money.COIN100);
        target.insert(Money.BILL1000);

        int actual = target.refund();

        assertThat(actual).isEqualTo(1200);
    }

    @Test
    void invalidMoney() {
        int change = target.insert(Money.COIN1);

        String actual = target.displayTotalAmount();

        assertThat(change).isEqualTo(1);
        assertThat(actual).isEqualTo("0");
    }
}
