package StringCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalcTest {
    StringCalculator calc = new StringCalculator();

    //Ej färdig
    @Test
    void inputOneTwoReturnThree() {
        assertEquals(3, calc.add("1, 2"));
    }

}
