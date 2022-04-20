
package com.example.JobFinder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicantController {
    
    @Autowired
    private ApplicantService applicantService;
    
    @Autowired
    private JobService jobService;
    
    @GetMapping("/applicant")
    public String getApplicant(Model model){
        ArrayList<Applicant> applicant = applicantService.getApplicant();
        model.addAttribute("applicant", applicant);
        return "applicant";
    }
    
    @PostMapping("/applicant")
    public String addApplicant(@RequestParam String applicantName, String applicantProfession, int applicantAge){
        System.out.println("Saatiin: " + applicantName);
        applicantService.addApplicant(applicantName, applicantProfession, applicantAge);
        return "redirect:/applicant/";
    }
   
    @PostMapping("/deleteapplicant")
    public String deleteApplicant(@RequestParam String applicantName){
        System.out.println("Poisto");
        applicantService.deleteApplicant(applicantName);
        return "redirect:/applicant/";
    }
    @GetMapping("applicant/{applicantName}")
    public String getUserInfo(@PathVariable String applicantName, Model model){
        Applicant applicant = applicantService.findApplicantByName(applicantName);
        model.addAttribute("user", applicant);
        return "user";
    }
}
