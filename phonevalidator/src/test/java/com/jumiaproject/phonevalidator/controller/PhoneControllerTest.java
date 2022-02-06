package com.jumiaproject.phonevalidator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumiaproject.phonevalidator.dto.PhoneValidatorResponseDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PhoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void shouldGet2xxResponse() throws Exception {

        this.mockMvc.perform(
                get("/phone/phones?country=MOZAMBIQUE")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void shouldGerEmptyListWhenCountryDoesNotExist() throws Exception {

         var response =  this.mockMvc.perform(
                get("/phone/phones?country=EGYPT")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                 .andReturn().getResponse().getContentAsString();

         var responseDto = mapper.readValue(response, PhoneValidatorResponseDto.class);

         Assert.assertTrue(responseDto.getPhones().isEmpty());

    }

    @Test
    public void shouldGerEmptyListWhenValidationStateDoesNotExist() throws Exception {

        var response =  this.mockMvc.perform(
                get("/phone/phones?validation-state=NOT_A_VALID_VALIDATION_STATE")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse().getContentAsString();

        var responseDto = mapper.readValue(response, PhoneValidatorResponseDto.class);

        Assert.assertTrue(responseDto.getPhones().isEmpty());

    }
}
