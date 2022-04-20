
package com.example.JobFinder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepository;
    
    public void addJob(String title, String description, String company){
        this.jobRepository.save(new Job(title, description, company));
    }
    
    public List<Job> getJobs(){
        return this.jobRepository.findAll();
    }
    
    public Job getJobByTitle(String title){
        return this.jobRepository.findByTitle(title).get(0);
    }
    
    @Transactional
    public void deleteJob(String title){
        Job job = jobRepository.findByTitle(title).get(0);
        this.jobRepository.deleteByTitle(title);
    }
}