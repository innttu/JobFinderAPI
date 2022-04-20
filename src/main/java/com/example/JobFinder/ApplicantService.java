
package com.example.JobFinder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicantService {
    
    
    @Autowired
    private ApplicantRepository applicantRepository;
    
    @Autowired 
    private JobService jobService;
    
    public void addApplicant(String name, String profession, int age){
        this.applicantRepository.save(new Applicant(name, profession, age));
    }
  
    public ArrayList<Applicant> getApplicant(){
        return this.applicantRepository.findAll();
    }
    
    public Applicant findApplicantByName(String applicantName){
        return this.applicantRepository.findByName(applicantName).get(0);
    }
    
    /*
    public void applyJob(String applicantName, String jobTitle){
        Applicant applicant = this.findApplicantByName(applicantName);
        Job job = jobService.getJobByTitle(jobTitle);
        System.out.println("loanjob: " + jobTitle + " ppl: " + applicant.toString() + " job: " + job.toString());
        applicant.applyJob(job);
        System.out.println("before saving: " + applicant.toString());
        this.applicantRepository.save(applicant);
    }
    
    public void returnJob(String applicantName, String jobTitle){
        Applicant applicant = this.findApplicantByName(applicantName);
        Job job = jobService.getJobByTitle(jobTitle);
        applicant.returnJob(job);
        this.applicantRepository.save(applicant);
    }
    
    public List<String> getAppliedJob(String userName){
        System.out.println("getLoanedJob: " + userName);
        Applicant applicant = this.findApplicantByName(userName);
        //System.out.println("applicant.getJobLoaned: " + applicant.getJobLoaned().toString());
        return applicant.getJobApplied();
    }
    */
    @Transactional
    public void deleteApplicant(String name){
        this.applicantRepository.deleteByName(name);
    }
    /*
    List<String> getAppliedJobs(String applicantName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/

}