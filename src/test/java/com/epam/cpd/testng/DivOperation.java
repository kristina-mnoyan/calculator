package com.epam.cpd.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.POSITIVE_INFINITY;

public class DivOperation extends BaseTest {

    @Test(dataProvider = "valuesForDivTestWithLongNumbers")
    public void divOperationTestForLongNumbers(long firstNumber, long secondNumber, long expectedResult, boolean isExpectedResultCorrect) {
        long actualResult = calculator.div(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Div Operation");
    }

    @DataProvider(name = "valuesForDivTestWithLongNumbers")
    public Object[][] valuesForDivTestWithLongNumbers() {
        return new Object[][]{
                {50, 5, 60, false},
                {-5000000, -16, 312500, true}
        };
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divOperationTestOnZero() {
        long actualResult = calculator.div(5000L, 0);
        Assert.assertNotEquals(actualResult, 0, "Invalid result of Div Operation");
    }

    @Test(dataProvider = "valuesForDivTestWithDoubleNumbers")
    public void divOperationForDoubleNumbers(double firstNumber, double secondNumber, double expectedResult, boolean isExpectedResultCorrect) {
        double actualResult = calculator.div(firstNumber, secondNumber);
        boolean isActualResultCorrect = actualResult == expectedResult;
        Assert.assertEquals(isActualResultCorrect, isExpectedResultCorrect, "Invalid result of Div Operation");
    }

    @DataProvider(name = "valuesForDivTestWithDoubleNumbers")
    public Object[][] valuesForDivTestWithDoubleNumbers() {
        return new Object[][]{
                {-5000000, -16, 312500, true},
                {50, 0, POSITIVE_INFINITY, true}
        };
    }
}
