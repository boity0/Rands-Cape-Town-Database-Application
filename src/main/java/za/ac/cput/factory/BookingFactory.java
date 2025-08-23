package za.ac.cput.factory;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingFactory {

    public static Booking build(String customerName, LocalDate bookingDate, LocalTime bookingTime, Gig gig) {
        return new Booking.Builder()
                .setCustomerName(customerName)
                .setBookingDate(bookingDate)
                .setBookingTime(bookingTime)
                .setGig(gig)
                .build();
    }
}

