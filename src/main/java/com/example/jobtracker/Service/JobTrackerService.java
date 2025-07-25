package com.example.jobtracker.Service;

import com.example.jobtracker.Entity.JobTrackerEntity;
import com.example.jobtracker.Enums.JobStatusEnum;
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

    public List<JobTrackerEntity> getJobByPosition(String position){
        return repository.findJobByPosition(position);
    }

    public JobTrackerEntity create(JobTrackerEntity entity){
        return repository.save(entity);
    }

    public List<JobTrackerEntity> isJobAvailable(String position){
        List<JobStatusEnum> activeStatuses = JobStatusEnum.getActiveStatuses();
        return repository.findByPositionAndStatusIn(position, activeStatuses);
    }

    public void updateJobStatus(Long id, String status) throws Exception {
        JobTrackerEntity job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job with " + id + " id was not found"));
        if(!JobStatusEnum.isValid(status)){
            throw new IllegalArgumentException("Invalid status " + status);
        }

        JobStatusEnum jobStatus = JobStatusEnum.valueOf(status.toUpperCase());
        job.setStatus(jobStatus);
        repository.save(job);
    }

    public void deleteJob(Long id){
        repository.deleteById(id);
    }

}
