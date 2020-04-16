package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowOperation extends BaseTest {
    @Test(dataProvider = "valuesForPowTestWithDoubleNumbers")
    public void powOperationTestForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.pow(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Pow Operation");
    }

    @DataProvider(name = "valuesForPowTestWithDoubleNumbers")
    public Object[][] valuesForPowTestWithDoubleNumbers() {
        return new Object[][]{
                {150.0625, 0.25, 3.5, false},
                {-1000, 0, 1, true}
        };
    }
}
