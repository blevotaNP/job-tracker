package com.example.jobtracker.Service;

import com.example.jobtracker.Entity.JobTrackerEntity;
import com.example.jobtracker.Repository.JobTrackerRepository;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class JobTrackerService {

    private final JobTrackerRepository repository;

    public JobTrackerService(JobTrackerRepository repository) {
        this.repository = repository;
    }

    public List<JobTrackerEntity> getAllJobs(){
        return repository.findAll();
    }

    public JobTrackerEntity getJobByPosition(String position){
        return repository.findJobByPosition(position);
    }

    public JobTrackerEntity create(JobTrackerEntity entity){
        return repository.save(entity);
    }
    public List<JobTrackerEntity> isJobAvailable(String position){
        List<String> statuses = Arrays.asList("Available", "Interview");
        return repository.findByPositionAndStatusIn(position, statuses);
    }

}
