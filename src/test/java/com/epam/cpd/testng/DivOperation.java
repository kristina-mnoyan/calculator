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
                {800, 4, 200, true},
                {-1000, 20, -50, true},
                {-5000000, -16, 312500, true},
                {50, 8, 60, false}
        };
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
                {800, 4, 200, true},
                {-1000.0004, 20, -50.00002, true},
                {-5000000, -16, 312500, true},
                {50, 0, POSITIVE_INFINITY, true}
        };
    }
}
