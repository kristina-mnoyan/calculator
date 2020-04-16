package com.epam.cpd.testng;

import core.logger.Logger;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j
public class SumOperation extends BaseTest {

    @Test(dataProvider = "valuesForSumTestWithLongNumbers")
    public void sumOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);
        log.info(Logger.Color.BLUE + String.format("%s,%d,%d,%d", "Checking the value of", firstNumber, secondNumber, actualResult));
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Sum Operation");
    }

    @DataProvider(name = "valuesForSumTestWithLongNumbers")
    public Object[][] valuesForSumTestWithLongNumbers() {
        return new Object[][]{
                {500, 800, 1300},
                {-1000, 3000, 2000},
                {-25, -45, -70},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "valuesForSumTestWithDoubleNumbers")
    public void sumOperationTestForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals((double) Math.round(actualResult * 100000d) / 100000d, expectedResult, "Invalid result of Sum Operation");
    }

    @DataProvider(name = "valuesForSumTestWithDoubleNumbers")
    public Object[][] valuesForSumTestWithDoubleNumbers() {
        return new Object[][]{
                {1985.55245, 4.78542, 1990.33787},
                {-0.55741, 3.8888745, 3.33146},
                {7.65, 5.777, 13.427},
                {-3.77, -8.147, -11.917}
        };
    }
}
