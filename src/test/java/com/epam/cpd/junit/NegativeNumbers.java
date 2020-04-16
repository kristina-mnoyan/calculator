package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class NegativeNumbers extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForNegativeLongNumbersTest")
    public void negativeLongNumbersTest(long argument, boolean expectedResult) {
        boolean actualResult = calculator.isNegative(argument);
        Assert.assertEquals(actualResult, expectedResult, "Invalid Number");
    }

    public static Object[][] valuesForNegativeLongNumbersTest() {
        return new Object[][]{
                {-1000L, true},
                {100L, false},
                {0, false}
        };
    }
}
