
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

    public Applicant(String appName, String appProfession, int appAge){
        this.name = appName;
        this.profession = appProfession;
        this.age = appAge;
    }
}
