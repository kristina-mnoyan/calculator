package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinusOperation extends BaseTest {
    @Test(dataProvider = "valuesForSinusTestWithDoubleNumbers")
    public void sinusOperationTestForDoubleNumbers(double argument, double expectedResult) {
        double actualResult = calculator.sin(argument);
        Assert.assertEquals((double) Math.round(actualResult * 10d) / 10d, expectedResult, "Invalid result of Sinus Operation");
    }

    @DataProvider(name = "valuesForSinusTestWithDoubleNumbers")
    public Object[][] valuesForSinTestWithDoubleNumbers() {
        return new Object[][]{
                {1.5 * Math.PI, -1},
                {1.17 * Math.PI, -0.5}
        };
    }
}
