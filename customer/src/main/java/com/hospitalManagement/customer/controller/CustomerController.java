package com.hospitalManagement.customer.controller;

import com.hospitalManagement.customer.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class    CustomerController {
    private Customers service;
    @Value("${project.file}")
    private File path;

    public CustomerController(Customers service) {
        this.service = service;
    }

    @GetMapping("/allNames")
    public List<Customer> getCustomer(){
        return service.findAll();
    }
    @PostMapping("/upload")
    public ResponseEntity<Customers> addCustomer(@RequestBody Customer customer){
        service.save(customer);
        return ResponseEntity.created(null).build();
    }
    //Improve in this method.
    @GetMapping("/findOne/{id}")
    public Customer getOne(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/fileUpload")
    public ResponseEntity<String> addFile(@RequestParam("image") MultipartFile image,Customers service) throws IOException {
        String filename= service.uploadImage(path,image).toString();
        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/file/").path(image.getOriginalFilename()).toUriString());
        //return new ResponseEntity<>("image submit successfully"+filename,HttpStatus.OK);
    }

    @PostMapping("/multiple-file-upload")
    public ResponseEntity<List<Map<String, String>>> handleMultipleFileUpload(@RequestParam("files") List<MultipartFile> files) throws IOException {
        List<Map<String, String>> fileList = new ArrayList<>();
        for (MultipartFile file : files) {
            Map<String, String> fileDetails = new HashMap<>();
            fileDetails.put("filename", file.getOriginalFilename());
            fileDetails.put("content-type", file.getContentType());
            fileDetails.put("size", String.valueOf(file.getSize()));
            fileList.add(fileDetails);
        }
        return ResponseEntity.ok(fileList);
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws IOException {
        Path filePath= Paths.get(path.toURI()).resolve(fileName).normalize();
        byte[] fileContent=Files.readAllBytes(filePath);
        return ResponseEntity.ok().header("Content-Disposition","attachement; fileName=\""+fileName+"\"")
                .body(fileContent);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Customer id){
        service.delete(id);
        return ResponseEntity.ok("delete Successfully");
    }
    //Update here-->Home work
    @PutMapping("/put/{id}")
    public ResponseEntity<String> exchangeValue(@RequestBody Customer customer, @PathVariable int id) {
        service.updateCustomer(customer, id);
        return ResponseEntity.ok("Update Successfully");
    }
}