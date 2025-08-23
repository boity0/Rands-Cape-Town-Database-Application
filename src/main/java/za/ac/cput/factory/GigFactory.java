package za.ac.cput.factory;
import za.ac.cput.domain.Gig;
import za.ac.cput.domain.DJ;
import za.ac.cput.domain.Timeslot;

public class GigFactory {

    public static Gig build(String gigVenue, double gigFee, DJ dj, Timeslot timeslot) {
        return new Gig.Builder()
                .setGigVenue(gigVenue)
                .setGigFee(gigFee)
                .setDj(dj)
                .setTimeslot(timeslot)
                .build();
    }
}
