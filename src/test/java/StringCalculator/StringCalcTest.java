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

    @Test
    void addNoInputReturnZero() {
        assertEquals(0, calc.add(""));
    }

    @Test
    void addInputFiveValues() {
        assertEquals(15, calc.add("1, 4, 2, 3, 5"));
    }

    @Test
    void addInputSeparatedByNewline() {
        assertEquals(3, calc.add("1\n2"));
    }

}
