package com.example.calculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    com.example.calculator.service.CalculatorService service = new com.example.calculator.service.CalculatorService();

    @Test
    void testAdd() {
        assertEquals(9, service.add(4, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(1, service.subtract(5, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(20, service.multiply(4, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, service.divide(5, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> service.divide(10, 0));
    }
}
