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

    public List<JobTrackerEntity> getJobByPosition(String position){
        return repository.findJobByPosition(position);
    }

    public JobTrackerEntity create(JobTrackerEntity entity){
        return repository.save(entity);
    }
    public List<JobTrackerEntity> isJobAvailable(String position){
        List<String> statuses = Arrays.asList("Available", "Interview");
        return repository.findByPositionAndStatusIn(position, statuses);
    }

    public void updateJobStatus(Long id, String status) throws Exception {
        JobTrackerEntity job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job with " + id + " id was not found"));
        List<String> statuses = Arrays.asList("AVAILABLE", "INTERVIEW", "CLOSED");
        if(statuses.contains(status.toUpperCase())){
            job.setStatus(status);
            repository.save(job);
        }
        else {
            throw new IllegalArgumentException("Incorrect Status!");
        }
    }

    public void deleteJob(Long id){
        repository.deleteById(id);
    }

}
