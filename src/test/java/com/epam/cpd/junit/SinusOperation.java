package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class SinusOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForSinusTestWithDoubleNumbers")
    public void sinusOperationTestForDoubleNumbers(double argument, double expectedResult) {
        double actualResult = calculator.sin(argument);
        Assert.assertEquals((double) Math.round(actualResult * 10d) / 10d, expectedResult, "Invalid result of Sinus Operation");
    }

    public static Object[][] valuesForSinusTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 0},
                {Math.PI / 2, 1},
                {1.5 * Math.PI, -1},
                {1.17 * Math.PI, -0.5}
        };
    }
}
