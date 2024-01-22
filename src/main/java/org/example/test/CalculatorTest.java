package org.example.test;
import org.example.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
    static Calculator calculator = null;
    @BeforeAll
    static void setUpBeforeClass() throws Exception{
        calculator = new Calculator();
        System.out.println("BeforeClass");
    }
    @BeforeEach
    void beforeEach() throws Exception
    {
        System.out.println("Calculator Setup is called");
    }
    @AfterEach
    void afterEach() throws Exception
    {
        System.out.println("Calculator teardown is called");
    }
    @Test
    void test()
    {
        fail("not yet Implemented");
    }
    @Test
    void testDivideBy1()
    {
        assertEquals(100,calculator.divide(1));
    }
    @Test
    void testDivideBy25()
    {
        assertEquals(100,calculator.divide(25));
    }
    @Test
    void testDivideBy100()
    {
        assertEquals(100,calculator.divide(100));
    }
    @Test
    void testDivideBy0()
    {
        assertThrows(ArithmeticException.class,()->{calculator.divide(0);});
    }
}
