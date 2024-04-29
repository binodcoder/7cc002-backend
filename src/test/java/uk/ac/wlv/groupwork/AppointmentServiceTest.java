package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.AppointmentRepository;
import uk.ac.wlv.groupwork.model.Appointment;
import uk.ac.wlv.groupwork.service.AppointmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppointmentServiceTest {

    @Test
    void testGetAllAppointments() {
        // Mock dependencies
        AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Create sample data
        List<Appointment> expectedAppointments = new ArrayList<>();
        expectedAppointments.add(new Appointment());
        expectedAppointments.add(new Appointment());

        // Stub the repository method
        when(appointmentRepository.findAll()).thenReturn(expectedAppointments);

        // Call the service method
        List<Appointment> result = appointmentService.getAllAppointments();

        // Verify the repository method is called
        verify(appointmentRepository).findAll();

        // Assert the result
        assertEquals(expectedAppointments, result);
    }

    @Test
    void testGetAppointmentById() {
        // Mock dependencies
        AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Create sample data
        int appointmentId = 1;
        Optional<Appointment> expectedAppointment = Optional.of(new Appointment());

        // Stub the repository method
        when(appointmentRepository.findById(eq(appointmentId))).thenReturn(expectedAppointment);

        // Call the service method
        Optional<Appointment> result = appointmentService.getAppointmentById(appointmentId);

        // Verify the repository method is called
        verify(appointmentRepository).findById(eq(appointmentId));

        // Assert the result
        assertEquals(expectedAppointment, result);
    }

    @Test
    void testAddAppointment() {
        // Mock dependencies
        AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Create sample data
        Appointment appointment = new Appointment();
        Appointment savedAppointment = new Appointment();

        // Stub the repository method
        when(appointmentRepository.save(appointment)).thenReturn(savedAppointment);

        // Call the service method
        Appointment result = appointmentService.addAppointment(appointment);

        // Verify the repository method is called
        verify(appointmentRepository).save(appointment);

        // Assert the result
        assertEquals(savedAppointment, result);
    }

    @Test
    void testUpdateAppointment() {
        // Mock dependencies
        AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Create sample data
        Appointment appointment = new Appointment();
        Appointment updatedAppointment = new Appointment();

        // Stub the repository method
        when(appointmentRepository.save(appointment)).thenReturn(updatedAppointment);

        // Call the service method
        Appointment result = appointmentService.updateAppointment(appointment);

        // Verify the repository method is called
        verify(appointmentRepository).save(appointment);

        // Assert the result
        assertEquals(updatedAppointment, result);
    }

    @Test
    void testDeleteAppointmentById() {
        // Mock dependencies
        AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Create sample data
        int appointmentId = 1;

        // Call the service method
        appointmentService.deleteAppointmentById(appointmentId);

        // Verify the repository method is called
        verify(appointmentRepository).deleteById(eq(appointmentId));
    }
}
