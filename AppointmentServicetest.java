package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private AppointmentService service;

    // Create a new service before each test
    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    // Create a future date for valid appointments
    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 86400000);
    }

    // Test that an appointment can be added
    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        service.addAppointment(appointment);

        assertEquals(
                appointment,
                service.getAppointment("A12345")
        );
    }

    // Test that a null appointment cannot be added
    @Test
    public void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(null);
        });
    }

    // Test that duplicate appointment IDs are not allowed
    @Test
    public void testDuplicateAppointmentId() {
        Appointment appointment1 = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        Appointment appointment2 = new Appointment(
                "A12345",
                futureDate(),
                "Dentist appointment"
        );

        service.addAppointment(appointment1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    // Test that an appointment can be retrieved by ID
    @Test
    public void testGetAppointment() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        service.addAppointment(appointment);

        Appointment result = service.getAppointment("A12345");

        assertNotNull(result);
        assertEquals("A12345", result.getAppointmentId());
    }

    // Test that an appointment can be deleted
    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        service.addAppointment(appointment);
        service.deleteAppointment("A12345");

        assertNull(service.getAppointment("A12345"));
    }

    // Test that deleting an appointment that does not exist
    // results in an exception
    @Test
    public void testDeleteNonexistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("A99999");
        });
    }
}
