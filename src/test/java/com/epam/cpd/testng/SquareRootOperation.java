package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SquareRootOperation extends BaseTest {
    @Test(dataProvider = "valuesForSquareRootTestWithDoubleNumbers")
    public void squareRootOperationTestForDoubleNumbers(double argument, double expectedResult) {
        double actualResult = calculator.sqrt(argument);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of SquareRoot Operation");
    }

    @DataProvider(name = "valuesForSquareRootTestWithDoubleNumbers")
    public Object[][] valuesForSquareRootTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 0},
                {100, 10},
                {0.0625, 0.25},
                {-4, 2}
        };
    }
}
