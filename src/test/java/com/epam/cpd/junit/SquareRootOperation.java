package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SquareRootOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForSquareRootTestWithDoubleNumbers")
    public void squareRootOperationTestForDoubleNumbers(double argument, double expectedResult) {
        double actualResult = calculator.sqrt(argument);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of SquareRoot Operation");
    }

    public static Object[][] valuesForSquareRootTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 0},
                {100, 10},
                {0.0625, 0.25},
                {-4, 2}
        };
    }
}
