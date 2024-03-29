package uk.ac.wlv.groupwork.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.model.Walk;

@Repository
public class WalkRepositoryCustomImpl implements WalkRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUserToWalk(User user, Walk walk) {
        // Execute native SQL query to insert a record into walk_participants table
        entityManager.createNativeQuery("INSERT INTO walk_participants (user_id, walk_id) VALUES (?, ?)")
                .setParameter(1, user.getId())
                .setParameter(2, walk.getId())
                .executeUpdate();
    }
}
