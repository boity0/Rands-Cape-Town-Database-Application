package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DJ;
import za.ac.cput.domain.Gig;
import za.ac.cput.domain.Timeslot;

import static org.junit.jupiter.api.Assertions.*;

class GigFactoryTest {

    @Test
    void testBuildGig() {
        DJ dj = new DJ();
        Timeslot timeslot = new Timeslot();

        Gig gig = GigFactory.build("Rands CPT", 500.0, dj, timeslot);

        assertNotNull(gig);
        assertEquals("Rands CPT", gig.getGigVenue());
        assertEquals(500.0, gig.getGigFee());
    }
}




    


