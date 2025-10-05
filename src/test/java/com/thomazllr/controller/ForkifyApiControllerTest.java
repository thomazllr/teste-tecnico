package com.thomazllr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thomazllr.common.FileUtils;
import com.thomazllr.controller.dto.ForkifySearchResponse;
import com.thomazllr.service.ForkifyApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = ForkifyApiController.class)
@Import(FileUtils.class)
class ForkifyApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ForkifyApiService forkifyApiService;

    @Autowired
    private ObjectMapper objectMapper;

    private ForkifySearchResponse response;

    @Autowired
    private FileUtils fileUtils;

    @BeforeEach
    void setUp() {
        response = new ForkifySearchResponse();
    }

    @Test
    @DisplayName("GET /v1/forkify?query=pizza returns ForkifySearchResponse when successful")
    void search_ReturnsForkifySearchResponse_WhenSuccessful() throws Exception {
        var query = "pizza";
        var expectedJson = fileUtils.readResourceFile("forkify/get-recipes-by-query-response-200.json");

        response = objectMapper.readValue(expectedJson, ForkifySearchResponse.class);

        BDDMockito.given(forkifyApiService.search(query)).willReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/forkify")
                        .param("query", query)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    @DisplayName("GET /v1/forkify without query param returns 400 Bad Request")
    void search_ReturnsBadRequest_WhenQueryParamMissing() throws Exception {

        var query = "null";

        BDDMockito.given(forkifyApiService.search(query)).willReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/forkify")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}