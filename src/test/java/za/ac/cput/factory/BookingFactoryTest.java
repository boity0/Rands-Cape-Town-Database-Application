package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void testBuildBooking() {
        Gig gig = new Gig();

        Booking booking = BookingFactory.build(
                "Boitumelo",
                LocalDate.now(),
                LocalTime.of(20, 0),
                gig
        );

        assertNotNull(booking);
        assertEquals("Boitumelo", booking.getCustomerName());
    }
}

