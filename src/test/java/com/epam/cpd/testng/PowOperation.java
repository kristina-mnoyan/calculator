package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowOperation extends BaseTest {
    @Test(dataProvider = "valuesForPowTestWithDoubleNumbers")
    public void powOperationTestForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.pow(firstNumber, secondNumber);
        Assert.assertEquals((double) Math.round(actualResult * 100000d) / 100000d, expectedResult, "Invalid result of Pow Operation");
    }

    @DataProvider(name = "valuesForPowTestWithDoubleNumbers")
    public Object[][] valuesForPowTestWithDoubleNumbers() {
        return new Object[][]{
                {2, 8, 256},
                {-1000, 0, 1},
                {-2.5, 3, -15.625},
                {-0.7, 4, 0.2401}
        };
    }
}
