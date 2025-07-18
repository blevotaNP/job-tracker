package com.example.jobtracker.Repository;

import com.example.jobtracker.Entity.JobTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTrackerRepository extends JpaRepository<JobTrackerEntity, Long> {

    JobTrackerEntity findJobByPosition(String position);
    JobTrackerEntity isAvailableJobByPosition(String position);
}
