package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class DivOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForDivTestWithLongNumbers")
    public void divOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult, boolean isExpectedResultCorrect) {
        long actualResult = calculator.div(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Div Operation");
    }

    public static Object[][] valuesForDivTestWithLongNumbers() {
        return new Object[][]{
                {800L, 4L, 200L, true},
                {-1000L, 20L, -50L, true},
        };
    }

    @ParameterizedTest
    @MethodSource("valuesForDivTestWithDoubleNumbers")
    public void divOperationForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.div(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Div Operation");
    }

    public static Object[][] valuesForDivTestWithDoubleNumbers() {
        return new Object[][]{
                {800, 4, 200, true},
                {-1000.0004, 20, -50.00002, true},
        };
    }
}
