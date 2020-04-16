package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class SubOperation extends BaseTest {
    @ParameterizedTest
    @MethodSource("valuesForSubTestWithLongNumbers")
    public void subOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sub(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Sub Operation");
    }

    public static Object[][] valuesForSubTestWithLongNumbers() {
        return new Object[][]{
                {500, 800, -300},
                {-1000, 3000, -4000},
                {-25, -45, 20},
                {0, 0, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("valuesForSubTestWithDoubleNumbers")
    public void subOperationForLongNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.sub(firstNumber, secondNumber);
        Assert.assertEquals((double) Math.round(actualResult * 100000d) / 100000d, expectedResult, "Invalid result of Sub Operation");
    }

    public static Object[][] valuesForSubTestWithDoubleNumbers() {
        return new Object[][]{
                {0.5475, 0.18, 0.3675},
                {-10.2658, -6.15, -4.1158},
                {-25.008, 45.1, -70.108},
                {1652.748, 254.3547, 1398.3933}
        };
    }

}
