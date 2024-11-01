package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    // Mein erstes aber nun obsolet
    // Ich nehme für die erste Teilaufgabe testPercentFunction()
    @Test
    @DisplayName("should display the number after pressing the number")
    void testPressDigitKey(){
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(5);



        String expected = "5";
        String actual = calculator.readScreen();
        assertEquals(expected, actual);

    }



    // Teilaufgabe 1
    @Test
    @DisplayName("should display the entered digit as a percentage")
    void testPercentFunction(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");

        String expected = "0.05";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


    // Teilaufgabe 2
    @Test
    @DisplayName("Pressing the key once, clears the previously entered digits on the screen so that '0' is displayed, but without deleting any previously stored values.")
    void testClearKeyKeepsPreviousOperation() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("+");

        calculator.pressDigitKey(3);
        calculator.pressClearKey();

        calculator.pressDigitKey(2);
        calculator.pressEqualsKey();

        String expected = "7";
        String actual = calculator.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should calculate the square root of 16")
    void testsquareRoot(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(16);
        calc.pressUnaryOperationKey("√");

        String expected = "4";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

