package Controller;

import Entity.JobTrackerEntity;
import Service.JobTrackerService;
import lombok.Getter;
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
}
