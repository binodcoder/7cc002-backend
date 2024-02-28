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

    @Autowired
    private UserRepository userRepository;

    public Object getAll(){
        if(userRepository.findAll().isEmpty()){
            //return (new HashMap<String, String>()).put("Error", "No Data");
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return errorMessage;
        } else {
            return userRepository.findAll();
        }
    }
}
