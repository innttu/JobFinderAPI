
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
        System.out.println("Test");
        return "applicant";
    }
    
    @PostMapping("/applicant")
    public String addApplicant(@RequestParam String applicantName){
        System.out.println("Saatiin: " + applicantName);
        applicantService.addApplicant(applicantName);
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
        Applicant user = applicantService.findApplicantByName(applicantName);
        List<Job> jobs = jobService.getJobs();
        List<String> appliedjobslist = applicantService.getAppliedJobs(applicantName);
        model.addAttribute("user", user);
        model.addAttribute("job", jobs);
        model.addAttribute("appliedjobslist", appliedjobslist);
        return "user";
    }
}
