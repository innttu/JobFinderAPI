
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
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    @Autowired
    private ApplicantService applicantService;
    
    @GetMapping("/jobs")
    public String getJobs(Model model){
        
        List<Job> jobs = jobService.getJobs();
        model.addAttribute("job", jobs);
        System.out.println("Testi");
        return "jobs";
    }
    
    @GetMapping("jobs/{jobTitle}")
    public String getJobInfo(@PathVariable String jobTitle, Model model){
        Job job = jobService.getJobByTitle(jobTitle);
        model.addAttribute("job", job);
        return "job";
    }
    
    @PostMapping("/jobs")
    public String addJob(@RequestParam String jobTitle, String jobDescription, String jobCompany){
        System.out.println("Saatiin: " + jobTitle);
        jobService.addJob(jobTitle, jobDescription, jobCompany);
        return "redirect:/jobs/";
    }
    
    @PostMapping("/deletejob")
    public String deleteJob(@RequestParam String jobTitle){
        System.out.println("kirjan poisto");
        jobService.deleteJob(jobTitle);
        return "redirect:/jobs/";
    }
    /*
    @PostMapping("/applyjob")
    public String applyJob(@RequestParam String userName, String jobTitle){
        applicantService.applyJob(userName, jobTitle);
        System.out.println("jobCont. user: " + userName + " job: " + jobTitle);

        return "redirect:/applicant/" + userName;
    }

    
    @PostMapping("/returnjob")
    public String returnJob(@RequestParam String userName, String jobTitle){
        applicantService.returnJob(userName, jobTitle);
        return "redirect:/applicant/" + userName;
    }
*/
}
