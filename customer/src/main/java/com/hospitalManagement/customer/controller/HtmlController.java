package com.hospitalManagement.customer.controller;

import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class HtmlController {
    @RequestMapping(value ="/about",method= RequestMethod.GET)
    public String about(Model model){
        System.out.println("This is about page.");
        model.addAttribute("name","Shashi");
        model.addAttribute("Date",new Date());
        return "about";
    }
    @RequestMapping(value ="/log",method= RequestMethod.GET)
    public String log(Model mo){
        System.out.println("This is log page");
        List<String> names= List.of("Shashi","Shudhakar","Madhav","Karan");
        mo.addAttribute("Names",names);
        return "log";
        //about.html
    }
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        System.out.println("This is login page");
        return "login";
    }
}
