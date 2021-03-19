package StringCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalcTest {
    StringCalculator calc = new StringCalculator();

    @Test
    void addInputOneTwoReturnThree() {
        assertEquals(3, calc.add("1, 2"));
    }

    @Test
    void addInputFourFiveReturnNine() {
        assertEquals(9, calc.add("4, 5"));
    }

}
