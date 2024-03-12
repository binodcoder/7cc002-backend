package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.UserRepository;
import uk.ac.wlv.groupwork.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public ResponseEntity<Object> getAll() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("EMPTY", "NO DATA");
                return ResponseEntity.ok(errorMessage);
            } else {
                return ResponseEntity.ok(users);
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    // Get a user by ID
    public ResponseEntity<Object> getUserById(int id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("NOT FOUND", "User with ID " + id + " not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    // Add a user
    public ResponseEntity<Object> addUser(User user) {
        try {
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    // Update a user
    public ResponseEntity<Object> updateUser(User user) {
        try {
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    // Delete a user by ID
    public ResponseEntity<Object> deleteUserById(int id) {
        try {
            userRepository.deleteById(id);
            Map<String, String> successMessage = new HashMap<>();
            successMessage.put("SUCCESS", "User with ID " + id + " deleted successfully");
            return ResponseEntity.ok(successMessage);
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
