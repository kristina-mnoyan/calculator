package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class MultiplyOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForMultiplyTestWithLongNumbers")
    public void multiplyOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.mult(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Multiply Operation");
    }

    public static Object[][] valuesForMultiplyTestWithLongNumbers() {
        return new Object[][]{
                {500L, 800L, 400000L},
                {-1000L, 3000L, -3000000L}
        };
    }

    @ParameterizedTest
    @MethodSource("valuesForMultiplyTestWithDoubleNumbers")
    public void multiplyOperationForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.mult(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Multiply Operation");
    }

    public static Object[][] valuesForMultiplyTestWithDoubleNumbers() {
        return new Object[][]{
                {51.78548, 8.621475, 446.467221183, false},
                {-100.1, 300.28, -30058.028, false},
        };
    }
}
