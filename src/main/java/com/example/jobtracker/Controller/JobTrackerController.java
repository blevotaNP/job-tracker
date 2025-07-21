package com.example.jobtracker.Controller;

import com.example.jobtracker.Entity.JobTrackerEntity;
import com.example.jobtracker.Service.JobTrackerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Map<String, String> body) throws Exception {
        String status = body.get("status");
        service.updateJobStatus(id, status);
        return ResponseEntity.ok("Updated succesfully");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
    }

    /*PLAN:
    add filters
    do a frontside with menu page, and pages for each of main methods
    read CV from file and save it
    edit CV
    read offers from site (file)
    */
}
