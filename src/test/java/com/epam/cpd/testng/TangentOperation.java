package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TangentOperation extends BaseTest {
    @Test(dataProvider = "valuesForTangentTestWithDoubleNumbers")
    public void tangentOperationTestForDoubleNumbers(double argument, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.tg(argument);
        boolean isActualResultCorrect = (double) Math.round(actualResult * 10d) / 10d == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Tangent Operation");
    }

    @DataProvider(name = "valuesForTangentTestWithDoubleNumbers")
    public Object[][] valuesForTangentTestWithDoubleNumbers() {
        return new Object[][]{
                {-0.25 * Math.PI, -1, false},
                {0.33 * Math.PI, 1.7, false}
        };
    }
}
