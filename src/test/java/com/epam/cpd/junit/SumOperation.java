package com.epam.cpd.junit;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

@Log4j
public class SumOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForSumTestWithLongNumbers")
    public void sumOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Sum Operation");
    }

    public static Object[][] valuesForSumTestWithLongNumbers() {
        return new Object[][]{
                {500L, 800L, 1300L},
                {-1000L, 3000L, 2000L},
        };
    }

    @ParameterizedTest
    @MethodSource("valuesForSumTestWithDoubleNumbers")
    public void sumOperationTestForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals((double) Math.round(actualResult * 100000d) / 100000d, expectedResult, "Invalid result of Sum Operation");
    }

    public static Object[][] valuesForSumTestWithDoubleNumbers() {
        return new Object[][]{
                {1245.759, 3.65782, 1249.41682},
                {-0.754, 5.217, 4.463},
        };
    }
}
