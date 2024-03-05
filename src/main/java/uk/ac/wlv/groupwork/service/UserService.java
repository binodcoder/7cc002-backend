package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.UserRepository;
import uk.ac.wlv.groupwork.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object getAll(){
        try {
            if(userRepository.findAll().isEmpty()){
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("ERROR", "NO DATA");
                return errorMessage;
            } else {
                return userRepository.findAll();
            }
        } catch (Exception e)
        {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR "+e.getMessage()+" ");
            return errorMessage;
        }
    }
}
