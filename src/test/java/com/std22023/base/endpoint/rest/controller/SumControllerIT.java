package com.std22023.base.endpoint.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.math.BigInteger;

@SpringBootTest
@AutoConfigureMockMvc
class SumControllerTest {

    private final MockMvc mockMvc;

    public SumControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    void testBigSum() throws Exception {
        String a = "100000000000000000000000000000000000000000000000000000000000";
        String b = "200000000000000000000000000000000000000000000000000000000000";
        BigInteger expectedSum = new BigInteger("300000000000000000000000000000000000000000000000000000000000");

        mockMvc.perform(get("/big-sum").param("a", a).param("b", b))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum").value(expectedSum.toString()));
    }
}
