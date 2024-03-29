package uk.ac.wlv.groupwork.dao;

import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.model.Walk;

public interface WalkRepositoryCustom {
    void addUserToWalk(User user, Walk walk);
}
