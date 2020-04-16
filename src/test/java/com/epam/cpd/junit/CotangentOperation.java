package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class CotangentOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForCotangentTestWithDoubleNumbers")
    public void cotangentOperationTestForDoubleNumbers(double argument, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.ctg(argument);
        boolean isActualResultCorrect = (double) Math.round(actualResult * 10d) / 10d == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Cotangent Operation");
    }

    public static Object[][] valuesForCotangentTestWithDoubleNumbers() {
        return new Object[][]{
                {-0.25 * Math.PI, -1, false},
                {0.17 * Math.PI, 1.7, false}
        };
    }
}
