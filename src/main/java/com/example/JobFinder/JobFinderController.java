/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JobFinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobFinderController {
    
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }
    
    @GetMapping("*")
    public String getDefault(){
        System.out.println("Redirecting");
        return "redirect:/";
    }
    
    
}
