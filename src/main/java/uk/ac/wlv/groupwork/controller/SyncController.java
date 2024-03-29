package uk.ac.wlv.groupwork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.wlv.groupwork.model.Company;
import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.service.CompanyService;
import uk.ac.wlv.groupwork.service.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sync")
public class SyncController {

    private final UserService userService;
    private final CompanyService companyService;

    public SyncController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<Object> syncData() {
        // Retrieve list of trainers
        List<User> trainers = userService.getAllTrainers();
        // Retrieve list of companies
        List<Company> companies = companyService.getAllCompanies();

        if(!trainers.isEmpty() || !companies.isEmpty()) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("message", "success");
            responseData.put("trainers", trainers);
            responseData.put("companies", companies);

            Map<String, Object> response = new HashMap<>();
            response.put("data", responseData);

            return ResponseEntity.ok(response);
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("message", "No trainers found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
