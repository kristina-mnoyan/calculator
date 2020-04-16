package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CotangentOperation extends BaseTest {
    @Test(dataProvider = "valuesForCotangentTestWithDoubleNumbers")
    public void cotangentOperationTestForDoubleNumbers(double argument, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.ctg(argument);
        boolean isActualResultCorrect = (double) Math.round(actualResult * 10d) / 10d == expectedResult;
        Assert.assertEquals(isActualResultCorrect,isExpectedResultCorrect, "Invalid result of Cotangent Operation");
    }

    @DataProvider(name = "valuesForCotangentTestWithDoubleNumbers")
    public Object[][] valuesForCotangentTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 0, true},
                {0.25 * Math.PI, 1, false},
                {-0.25 * Math.PI, -1, false},
                {0.17 * Math.PI, 1.7, false}
        };
    }
}
