package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosineOperation extends BaseTest {
    @Test(dataProvider = "valuesForCosineTestWithDoubleNumbers")
    public void cosineOperationTestForDoubleNumbers(double argument, double expectedResult) {
        double actualResult = calculator.cos(argument);
        Assert.assertNotEquals((double) Math.round(actualResult * 10d) / 10d, expectedResult, "Invalid result of Cosine Operation");
    }

    @DataProvider(name = "valuesForCosineTestWithDoubleNumbers")
    public Object[][] valuesForCosineTestWithDoubleNumbers() {
        return new Object[][]{
                {0, 1},
                {Math.PI / 2, 0}
        };
    }
}
