
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
