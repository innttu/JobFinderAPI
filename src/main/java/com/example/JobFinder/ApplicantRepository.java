
package com.example.JobFinder;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    @Override
    ArrayList<Applicant> findAll();
    
    ArrayList<Applicant> findByName(String name);
    
    Long deleteByName(String name);
}