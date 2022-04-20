
package com.example.JobFinder;

import java.util.ArrayList;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job extends AbstractPersistable<Long> {
    private String title;
    private String description;
    private String company;
    //private boolean applied = false;
    
    
    public Job(String jobTitle, String jobDescription, String jobCompany){
        this.title = jobTitle;
        this.description = jobDescription;
        this.company = jobCompany;
    }
}

