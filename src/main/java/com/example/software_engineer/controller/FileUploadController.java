package com.example.software_engineer.controller;


import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    private final Path rootLocation = Paths.get("src/main/resources/static/img/");

    @PostMapping("/upload-image")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        // Extract the original file name
        String originalFileName = file.getOriginalFilename();

        // Check if the original file name is not null and has an extension
        if (originalFileName == null || !originalFileName.contains(".")) {
            return "Invalid file name";
        }

        // Define a relative path with the original file name
        String relativePath = "src/main/resources/static/img/" + originalFileName;

        // Resolve the path relative to the current working directory
        File destinationFile = new File(relativePath).getAbsoluteFile();

        // Ensure that parent directories exist
        if (!destinationFile.getParentFile().exists()) {
            destinationFile.getParentFile().mkdirs();
        }

        // Save the file
        try {
            file.transferTo(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error during file upload: " + e.getMessage();
        }
        return "File uploaded successfully";
    }

    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<FileSystemResource> serveFile(@PathVariable String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            FileSystemResource resource = new FileSystemResource(file);

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete-image/{fileName}")
    public String deleteFile(@PathVariable String fileName) {

        // Define the relative path with the file name
        String relativePath = "src/main/resources/static/img/" + fileName+".png";

        // Resolve the path relative to the current working directory
        File fileToDelete = new File(relativePath).getAbsoluteFile();
        System.out.println(fileToDelete.exists());

        // Check if the file exists
        if (!fileToDelete.exists()) {
            System.out.println("File not found");
            return "File not found";
        }

        // Attempt to delete the file
        if (fileToDelete.delete()) {
            System.out.println("File deleted successfully");
            return "File deleted successfully";
        } else {
            System.out.println("Failed to delete the file");
            return "Failed to delete the file";
        }
    }
}

