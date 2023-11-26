package com.example.software_engineer;

import com.example.software_engineer.controller.UserController;
import com.example.software_engineer.repository.JSONRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private JSONRepository jsonRepository;

    @Test
    public void testGetAccount() throws Exception {
        String username = "Admin";
        mockMvc.perform(get("/user/account/{username}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddToShoppingCart() throws Exception {
        String username = "Admin";
        String UID = "3";

        doNothing().when(jsonRepository).addInShoppingcart(username, UID);

        mockMvc.perform(post("/user/cart/{username}/{UID}", username, UID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testRemoveFromShoppingCart() throws Exception {
        mockMvc.perform(delete("/user/cart/{username}/{UID}", "Admin", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testClearShoppingCart() throws Exception {
        mockMvc.perform(delete("/user/cart/{username}", "Admin")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testCreateOrder() throws Exception {
        mockMvc.perform(post("/user/order/{username}", "Admin")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testDeleteService() throws Exception {
        mockMvc.perform(delete("/user/services/{username}/{UID}", "Admin", "3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
