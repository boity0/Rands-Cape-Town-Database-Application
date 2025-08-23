package za.ac.cput.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private GigRepository gigRepository;

    @Test
    void testSaveAndFind() {
        Gig gig = new Gig.Builder()
                .setGigVenue("Rands CPT")
                .setGigFee(500.0)
                .build();
        Gig savedGig = gigRepository.save(gig);

        Booking booking = new Booking.Builder()
                .setCustomerName("Chantel")
                .setBookingDate(LocalDate.now())
                .setBookingTime(LocalTime.of(21, 0))
                .setGig(savedGig)
                .build();

        Booking saved = repository.save(booking);
        assertNotNull(saved.getBookingId());

        Optional<Booking> found = repository.findById(saved.getBookingId());
        assertTrue(found.isPresent());
        assertEquals("Chantel", found.get().getCustomerName());
    }
}


