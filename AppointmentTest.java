package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    // Create a future date that can be used for valid appointments
    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 86400000);
    }

    // Test a valid appointment
    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        assertEquals("A12345", appointment.getAppointmentId());
        assertEquals("Doctor appointment", appointment.getDescription());
        assertNotNull(appointment.getAppointmentDate());
    }

    // Test that appointment ID cannot be null
    @Test
    public void testAppointmentIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    null,
                    futureDate(),
                    "Doctor appointment"
            );
        });
    }

    // Test that appointment ID cannot be longer than 10 characters
    @Test
    public void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "12345678901",
                    futureDate(),
                    "Doctor appointment"
            );
        });
    }

    // Test that appointment ID cannot be changed
    @Test
    public void testAppointmentIdCannotBeUpdated() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        // There is no setter for appointment ID.
        // The ID should remain the same after creation.
        assertEquals("A12345", appointment.getAppointmentId());
    }

    // Test that appointment date cannot be null
    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "A12345",
                    null,
                    "Doctor appointment"
            );
        });
    }

    // Test that appointment date cannot be in the past
    @Test
    public void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "A12345",
                    pastDate,
                    "Doctor appointment"
            );
        });
    }

    // Test that appointment date can be updated to a future date
    @Test
    public void testAppointmentDateCanBeUpdated() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        Date newDate = new Date(System.currentTimeMillis() + 172800000);

        appointment.setAppointmentDate(newDate);

        assertEquals(newDate, appointment.getAppointmentDate());
    }

    // Test that description cannot be null
    @Test
    public void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "A12345",
                    futureDate(),
                    null
            );
        });
    }

    // Test that description cannot be longer than 50 characters
    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "A12345",
                    futureDate(),
                    "This description is longer than fifty characters and invalid"
            );
        });
    }

    // Test that description can be updated
    @Test
    public void testDescriptionCanBeUpdated() {
        Appointment appointment = new Appointment(
                "A12345",
                futureDate(),
                "Doctor appointment"
        );

        appointment.setDescription("Dentist appointment");

        assertEquals("Dentist appointment", appointment.getDescription());
    }
}
