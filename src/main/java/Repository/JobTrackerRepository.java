package Repository;

import Entity.JobTrackerEntity;
import org.springframework.data.repository.CrudRepository;

public interface JobTrackerRepository extends CrudRepository<JobTrackerEntity, Long> {

}
