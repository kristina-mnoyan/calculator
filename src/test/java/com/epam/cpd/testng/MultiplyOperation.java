package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyOperation extends BaseTest {

    @Test(dataProvider = "valuesForMultiplyTestWithLongNumbers")
    public void multiplyOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.mult(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Multiply Operation");
    }

    @DataProvider(name = "valuesForMultiplyTestWithLongNumbers")
    public Object[][] valuesForMultiplyTestWithLongNumbers() {
        return new Object[][]{
                {500, 800, 400000},
                {-1000, 3000, -3000000},
                {-25, -45, 1125},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "valuesForMultiplyTestWithDoubleNumbers")
    public void multiplyOperationForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.mult(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Invalid result of Multiply Operation");
    }

    @DataProvider(name = "valuesForMultiplyTestWithDoubleNumbers")
    public Object[][] valuesForMultiplyTestWithDoubleNumbers() {
        return new Object[][]{
                {51.78548, 8.621475, 446.467221183},
                {-100.1, 300.28, -30058.028},
                {-25.2147, -45.26, 1141.217322},
                {0, 0.154787496, 0}
        };
    }
}
