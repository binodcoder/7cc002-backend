package uk.ac.wlv.groupwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.wlv.groupwork.model.Coach;
import uk.ac.wlv.groupwork.model.User;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Integer> {

}
