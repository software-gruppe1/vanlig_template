package com.example.software_engineer;

import com.example.software_engineer.controller.FileUploadController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileUploadController.class)
public class FileUploadControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private FileSystemResource fileSystemResource;

    @Test
    public void testHandleFileUpload() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.png",
                "text/plain",
                "some content".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/upload-image")
                        .file(file))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("File uploaded successfully"))
                .andDo(print());

        String filename = "test";
        when(fileSystemResource.exists()).thenReturn(true);
        when(fileSystemResource.isReadable()).thenReturn(true);

        mockMvc.perform(delete("/delete-image/" + filename));
    }

    @Test
    public void testServeFile_ifFound() throws Exception{
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "servethis.png",
                "text/plain",
                "some content".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/upload-image")
                .file(file));

        String filename = "servethis";
        when(fileSystemResource.exists()).thenReturn(true);
        when(fileSystemResource.isReadable()).thenReturn(true);

        mockMvc.perform(get("/images/" + filename+".png"))
                .andExpect(status().isOk())
                        .andDo(print());

        mockMvc.perform(delete("/delete-image/" + filename))
                .andExpect(status().isOk());
    }

    @Test
    public void testServeFile_ifNotFound() throws Exception{
        String filename = "nothere";
        when(fileSystemResource.exists()).thenReturn(false);
        when(fileSystemResource.isReadable()).thenReturn(true);

        mockMvc.perform(get("/images/" + filename))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteFile_ifFound() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "deletethis.png",
                "text/plain",
                "delete".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/upload-image")
                        .file(file))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("File uploaded successfully"));

        String filename = "deletethis";
        when(fileSystemResource.exists()).thenReturn(true);
        when(fileSystemResource.isReadable()).thenReturn(true);

        mockMvc.perform(delete("/delete-image/" + filename))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteFile_ifNotFound() throws Exception {
        String filename = "notdeleted.png";
        when(fileSystemResource.exists()).thenReturn(false);
        when(fileSystemResource.isReadable()).thenReturn(true);

        mockMvc.perform(delete("/delete-image/" + filename))
                .andExpect(MockMvcResultMatchers.content().string("File not found"));
    }

}
