
package com.example.JobFinder;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Long>{
    @Override
    ArrayList<Job> findAll();
    ArrayList<Job> findByTitle(String title);
    Long deleteByTitle(String title);
}