package com.example.software_engineer;

import com.example.software_engineer.controller.AdvertisementController;
import com.example.software_engineer.model.Services;
import com.example.software_engineer.model.Reviews;
import com.example.software_engineer.repository.JSONRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(AdvertisementController.class)
@ExtendWith(SpringExtension.class)
public class AdvertisementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JSONRepository jsonRepository;

    @Test
    public void TestGetAllAdvertisements() throws Exception {
        List<Services> servicesList = Arrays.asList(
                new Services("TestService", LocalDate.now(), 100, "TestDescription", "TestLocation", "TestAccount", "TestUID1"),
                new Services("TestService1", LocalDate.now(), 200, "TestDescription", "TestLocation", "TestAccount", "TestUID2")
        );
        when(jsonRepository.allServices()).thenReturn(servicesList);

        mockMvc.perform(get("/advertisement/services/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].serviceName", is("TestService")))
                .andExpect(jsonPath("$[1].serviceName", is("TestService1")));
    }

    @Test
    public void TestCreateService() throws Exception {
        Services mockService = new Services("TestService2", LocalDate.now(), 100, "TestDescription", "Test", "TestAccount", "TestUID3");

        mockMvc.perform(post("/advertisement/services")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockService)))
                .andExpect(status().isCreated())
                .andDo(print());

        verify(jsonRepository).createService(
                eq("TestService2"),
                eq("TestDescription"),
                eq("Test"),
                eq(mockService.getDate()),
                eq(100),
                eq("TestAccount"),
                eq("TestUID3")
        );
    }

    @Test
    public void TestUpdateService() throws Exception {
        Services serviceUpdate = new Services("Testupdate", LocalDate.now(), 100, "TestDescription", "Test", "TestAccount", "TestUID4");

        mockMvc.perform(put("/advertisement/services/" + serviceUpdate.getUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(serviceUpdate)))
                .andExpect(status().isOk())
                .andDo(print());

        verify(jsonRepository).changeService(
                eq("Testupdate"),
                eq("TestDescription"),
                eq("Test"),
                eq(serviceUpdate.getDate()),
                eq(100),
                eq("TestAccount"),
                eq("TestUID4")

        );
    }

    @Test
    public void TestAddReviewToService() throws Exception {
        Reviews mockReview = new Reviews("TestReview", "TestDescriptionReview", 5);
        Services mockService = new Services("TestAddReview", LocalDate.now(), 100, "TestDescription", "Test", "TestAccount", "TestUID5");

        when(jsonRepository.spesificService(eq("TestUID5"))).thenReturn(mockService);

        mockMvc.perform(post("/advertisement/reviews/{UID}", "TestUID5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockReview)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void TestGetSpecificService() throws Exception {
        Services MockService = new Services("TestSpecific", LocalDate.now(), 100, "TestDescription", "Test", "TestAccount", "TestUID6");

        when(jsonRepository.spesificService(eq("TestUID6"))).thenReturn(MockService);

        mockMvc.perform(get("/advertisement/{UID}", "TestUID6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uid", is("TestUID6")))
                .andDo(print());

        verify(jsonRepository).spesificService(eq("TestUID6"));
    }
}
