package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class SquareRootOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForSquareRootTestWithDoubleNumbers")
    public void squareRootOperationTestForDoubleNumbers(double argument, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.sqrt(argument);
        boolean isActualResultCorrect = actualResult==expectedResult;
        Assert.assertNotEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of SquareRoot Operation");
    }

    public static Object[][] valuesForSquareRootTestWithDoubleNumbers() {
        return new Object[][]{
                {-0.1225, 0.35, false},
                {-4, 2, false}
        };
    }
}
