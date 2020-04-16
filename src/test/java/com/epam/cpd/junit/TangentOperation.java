package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class TangentOperation extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForTangentTestWithDoubleNumbers")
    public void tangentOperationTestForDoubleNumbers(double argument, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.tg(argument);
        boolean isActualResultCorrect = (double) Math.round(actualResult * 10d) / 10d == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Tangent Operation");
    }

    public static Object[][] valuesForTangentTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 0, true},
                {0.25 * Math.PI, 1, true}
        };
    }
}
