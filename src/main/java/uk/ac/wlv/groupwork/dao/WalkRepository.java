package uk.ac.wlv.groupwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uk.ac.wlv.groupwork.model.Walk;

import java.util.List;

@Repository
public interface WalkRepository extends JpaRepository<Walk, Integer>, WalkRepositoryCustom {

    //SQL
    //@Query("SELECT w.*, u.* FROM walks w INNER JOIN walk_participants wp ON w.id = wp.walk_id INNER JOIN users u ON wp.user_id = u.id");
    //JPQL
   // @Query("SELECT w, u FROM Walk w JOIN WalkParticipant wp ON w.id = wp.walk.id JOIN User u ON wp.user.id = u.id")
   // @Query("SELECT DISTINCT w FROM Walk w LEFT JOIN FETCH w.participants")
   // @Query("SELECT DISTINCT w FROM Walk w JOIN FETCH w.participants p")
   // @Query("SELECT DISTINCT w FROM Walk w JOIN FETCH w.participants p JOIN FETCH p.user")
    @Query("SELECT DISTINCT w FROM Walk w JOIN FETCH w.participants p JOIN FETCH p.user")
    List<Walk> findAllWalksWithParticipants();
}
