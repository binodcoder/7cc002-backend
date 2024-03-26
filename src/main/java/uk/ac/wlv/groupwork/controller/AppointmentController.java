package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Appointment;
import uk.ac.wlv.groupwork.service.AppointmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(appointments);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAppointmentById(@PathVariable int id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        if (appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Appointment with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment) {
        Appointment addedAppointment = appointmentService.addAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAppointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        if (!appointmentService.getAppointmentById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Appointment with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        appointment.setId(id);
        Appointment updatedAppointment = appointmentService.updateAppointment(appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAppointmentById(@PathVariable int id) {
        if (!appointmentService.getAppointmentById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Appointment with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok().build();
    }
}
