package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosineOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForCosineTestWithDoubleNumbers")
    public void cosineOperationTestForDoubleNumbers(double argument, double expectedResult) {
        double actualResult = calculator.cos(argument);
        Assert.assertNotEquals((double) Math.round(actualResult * 10d) / 10d, expectedResult, "Invalid result of Cosine Operation");
    }

    public static Object[][] valuesForCosineTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 1},
                {Math.PI / 2, 0},
                {Math.PI, -1},
                {0.66 * Math.PI, -0.5}
        };
    }
}
