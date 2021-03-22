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

    @Test
    void addInputWithDifferentSeparation() {
        assertEquals(7, calc.add("2, 4\n1"));
    }

    @Test
    void addWithOtherSeparators() {
        assertEquals(4, calc.add("//;\n1;3"));
    }

    @Test
    void addWithNegativeValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("-3, -1"));
    }

    @Test
    void addIgnoresLargerThan1000() {
        assertEquals(3, calc.add("1003, 1, 2"));
    }

    @Test
    void addLongerDelimitersAccepted() {
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }

    @Test
    void addMultipleCustomDelimiters() {
        assertEquals(6, calc.add("//[*][%]\n1*2%3"));
    }

    @Test
    void MultipleLongCustomDelimiters() {
        assertEquals(50, calc.add("//[optimus][megatron][starscream]\n20optimus15starscream5megatron10"));
    }

}
