package com.hospitalManagement.customer.controller;

import com.hospitalManagement.customer.Customer;
import com.hospitalManagement.customer.entity.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class Customers {
    @Autowired
    private CustomerRepo customerRepo;
    //List<Customer> list=new ArrayList<Customer>();
    private int id=100;

    public Map<String,String> uploadImage(File path, MultipartFile image) throws IOException {
        String filename= image.getOriginalFilename();
        String filePath=path+File.separator+filename;
        Map<String,String> map=new LinkedHashMap<>();
        map.put(filename , image.getContentType());
//      map.put("file Content type",file.getContentType());
        File folder=new File(String.valueOf(path));
        if(!folder.exists()){
            folder.mkdir();
        }else{
            Files.copy(image.getInputStream(), Paths.get(filePath));
        }
        return map;
    }

    public List<Customer> findAll() {
        List<Customer> list= (List<Customer>) this.customerRepo.findAll();
        return list;
//        list.add(new Customer(++id,"Raghav",24,"Male",68.90,"9834245671"));
//        list.add(new Customer(++id,"Madhav",24,"Male",63.90,"9834244567"));
//        list.add(new Customer(++id,"Anand",24,"Male",64.60,"9234565671"));
//        return list;
    }
    public Customer save(Customer customer) {
        Customer care= customerRepo.save(customer);
//        customer.setId(++id);
//        list.add(customer);
       return care;
    }
    public void delete(Customer id){
        this.customerRepo.delete(id);
//        return customer;
    }

    public Customer findOne(int id) {
       Customer cus= customerRepo.findByid(id);
//        Predicate<? super Customer> predicate=customer -> customer.getId().equals(id);
//        return list.stream().filter(predicate).findFirst().get();
        return cus;
    }
//Update here-->Home work
    public void updateCustomer(Customer customer, int id) {
        customer.setId(id);
        customerRepo.save(customer);
    }
}
