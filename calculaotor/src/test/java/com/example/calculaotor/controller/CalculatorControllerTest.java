package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(com.example.calculator.controller.CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testAddEndpoint() throws Exception {
        when(calculatorService.add(3, 4)).thenReturn(7);

        mockMvc.perform(get("/api/calc/add?a=3&b=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    void testDivideByZero() throws Exception {
        when(calculatorService.divide(5, 0)).thenThrow(new ArithmeticException("Cannot divide by zero"));

        mockMvc.perform(get("/api/calc/divide?a=5&b=0"))
                .andExpect(status().isInternalServerError());
    }
}
