package com.epam.cpd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

public class PositiveNumbers extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForPositiveLongNumbersTest")
    public void positiveLongNumbersTest(long argument, boolean expectedResult) {
        boolean actualResult = calculator.isPositive(argument);
        Assert.assertEquals(actualResult, expectedResult, "Invalid Number");
    }

    public static Object[][] valuesForPositiveLongNumbersTest() {
        return new Object[][]{
                {-658215, false},
                {548552248, true},
                {0, false}
        };
    }
}
