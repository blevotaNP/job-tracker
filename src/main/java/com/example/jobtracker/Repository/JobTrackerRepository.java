package com.example.jobtracker.Repository;

import com.example.jobtracker.Entity.JobTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTrackerRepository extends JpaRepository<JobTrackerEntity, Long> {

    List<JobTrackerEntity> findJobByPosition(String position);

    List<JobTrackerEntity> findByPositionAndStatusIn(String position, List<String> statuses);
}
