package org.example.test;
import org.example.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({CalcParaTest.class, CalculatorTest.class})
public class TestCalculatorSuite {

    static Calculator calculator = null;
    @BeforeAll
    static void setUpBeforeClass() throws Exception{
        calculator = new Calculator();
        System.out.println("BeforeClass");
    }
    @AfterAll
    static void setUpAfterClass() throws Exception{
        calculator = new Calculator();
        System.out.println("AfterClass");
    }

}
