package com.epam.cpd.testng;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j
public class SumOperation extends BaseTest {

    @Test(dataProvider = "valuesForSumTestWithLongNumbers")
    public void sumOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Sum Operation");
    }

    @DataProvider(name = "valuesForSumTestWithLongNumbers")
    public Object[][] valuesForSumTestWithLongNumbers() {
        return new Object[][]{
                {-25, -45, -70},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "valuesForSumTestWithDoubleNumbers")
    public void sumOperationTestForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals((double) Math.round(actualResult * 1000d) / 1000d, expectedResult, "Invalid result of Sum Operation");
    }

    @DataProvider(name = "valuesForSumTestWithDoubleNumbers")
    public Object[][] valuesForSumTestWithDoubleNumbers() {
        return new Object[][]{
                {7.65, 5.777, 13.427},
                {-3.77, -8.147, -11.917}
        };
    }
}
