package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SquareRootOperation extends BaseTest {
    @Test(dataProvider = "valuesForSquareRootTestWithDoubleNumbers")
    public void squareRootOperationTestForDoubleNumbers(double argument, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.sqrt(argument);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of SquareRoot Operation");
    }

    @DataProvider(name = "valuesForSquareRootTestWithDoubleNumbers")
    public Object[][] valuesForSquareRootTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 0, true},
                {0.0625, 0.25, true}

        };
    }
}
