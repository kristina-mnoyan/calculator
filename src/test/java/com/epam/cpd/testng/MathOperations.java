package com.epam.cpd.testng;

import core.Logger;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j
public class MathOperations extends BaseTest {
    @Test(dataProvider = "valuesForSumTest")
    public void sumOperationTest(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);
        log.info(Logger.Color.BLUE + String.format("%s,%d,%d,%d","Checking the value of", firstNumber, secondNumber, actualResult));
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Sum Operation");
    }

    @DataProvider(name = "valuesForSumTest")
    public Object[][] valuesForSumTest() {
        return new Object[][]{
                {500, 800, 1300},
                {-1000, 3000, 2000},
                {-25, -45, -70},
                {0, 0, 0}
        };
    }

}
