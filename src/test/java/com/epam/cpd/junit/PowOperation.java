package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class PowOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForPowTestWithDoubleNumbers")
    public void powOperationTestForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.pow(firstNumber, secondNumber);
        Assert.assertEquals((double) Math.round(actualResult * 100000d) / 100000d, expectedResult, "Invalid result of Pow Operation");
    }

    public static Object[][] valuesForPowTestWithDoubleNumbers() {
        return new Object[][]{
                {2, 8, 256},
                {-1000, 0, 1},
                {-2.5, 3, -15.625},
                {-0.7, 4, 0.2401}
        };
    }
}
