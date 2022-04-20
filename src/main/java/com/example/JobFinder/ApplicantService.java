
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
    
    @Transactional
    public void deleteApplicant(String name){
        this.applicantRepository.deleteByName(name);
    }
}