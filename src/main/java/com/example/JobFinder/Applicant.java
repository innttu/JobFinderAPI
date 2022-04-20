
package com.example.JobFinder;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Applicant extends AbstractPersistable<Long>{
    private String name;
    private String profession;
    private int age;
    //private int appliedJobs = 0;
    //private ArrayList<String> vacancies;

    public Applicant(String appName, String appProfession, int appAge){
        this.name = appName;
        this.profession = appProfession;
        this.age = appAge;
        //this.vacancies = new ArrayList<>();
    }
}
       /*
    public void applyJob(Job job){
        System.out.println("applyjob: " + job.getTitle());
        job.setApplied(true);
        String jobTitle = job.getTitle();
        this.vacancies.add(jobTitle);
        this.appliedJobs += 1;
        System.out.println("in appliedjobs: " + this.name + " numvacanciess: " + this.appliedJobs);
    }
    /*
    /*
    public void returnBooks(Job job){
        String jobTitle = job.getTitle();
        this.vacancies.remove(jobTitle);
        job.setApplied(false);
        this.appliedJobs -= 1;
        if (this.appliedJobs < 0){
            this.appliedJobs = 0;
        }
    */
    
    /*
    public List<String> getVacancies(){
        System.out.println("in getvacancies: " + this.vacancies.toString() + " name: " + this.name);
        return this.vacancies;
    }

    void returnJob(Job job) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<String> getJobApplied() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
