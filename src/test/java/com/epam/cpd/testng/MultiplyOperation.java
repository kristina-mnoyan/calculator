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
                {-25, -45, 1125},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "valuesForMultiplyTestWithDoubleNumbers")
    public void multiplyOperationForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.mult(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Multiply Operation");
    }

    @DataProvider(name = "valuesForMultiplyTestWithDoubleNumbers")
    public Object[][] valuesForMultiplyTestWithDoubleNumbers() {
        return new Object[][]{
                {-25.2147, -45.26, 1141.217322, false},
                {0, 0.154787496, 0, true}
        };
    }
}
