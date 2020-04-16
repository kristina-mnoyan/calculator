package com.epam.cpd.junit;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}
