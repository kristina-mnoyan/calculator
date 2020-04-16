package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveNumbers extends BaseTest {
    @Test(dataProvider = "valuesForPositiveLongNumbersTest")
    public void positiveLongNumbersTest(long argument, boolean expectedResult) {
        boolean actualResult = calculator.isPositive(argument);
        Assert.assertEquals(actualResult, expectedResult, "Invalid Number");
    }

    @DataProvider(name = "valuesForPositiveLongNumbersTest")
    public Object[][] valuesForPositiveLongNumbersTest() {
        return new Object[][]{
                {-658215L, false},
                {548552248L, true},
                {0, false}
        };
    }
}
