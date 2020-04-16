package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeNumbers extends BaseTest {
    @Test(dataProvider = "valuesForNegativeLongNumbersTest")
    public void negativeLongNumbersTest(long argument, boolean expectedResult) {
        boolean actualResult = calculator.isNegative(argument);
        Assert.assertEquals(actualResult, expectedResult, "Invalid Number");
    }

    @DataProvider(name = "valuesForNegativeLongNumbersTest")
    public Object[][] valuesForNegativeLongNumbersTest() {
        return new Object[][]{
                {-1000, true},
                {100, false},
                {0, false}
        };
    }
}
