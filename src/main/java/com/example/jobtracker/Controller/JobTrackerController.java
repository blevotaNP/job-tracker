package com.example.jobtracker.Controller;

import com.example.jobtracker.Entity.JobTrackerEntity;
import com.example.jobtracker.Service.JobTrackerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobTrackerController {
    private final JobTrackerService service;

    public JobTrackerController(JobTrackerService service) {
        this.service = service;
    }

    @PostMapping
    public JobTrackerEntity createJob(@RequestBody JobTrackerEntity entity) {
        return service.create(entity);
    }

    @GetMapping
    public List<JobTrackerEntity> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/{position}")
    public List<JobTrackerEntity> getJobByPosition(@PathVariable String position) {
        return service.getJobByPosition(position);
    }

    @GetMapping("/available/{position}")
    public List<JobTrackerEntity> getAvailableJobs(@PathVariable String position) {
        return service.isJobAvailable(position);
    }
}
