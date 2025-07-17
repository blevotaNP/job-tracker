package Repository;

import Entity.JobTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JobTrackerRepository extends JpaRepository<JobTrackerEntity, Long> {

    JobTrackerEntity getJob();
}
