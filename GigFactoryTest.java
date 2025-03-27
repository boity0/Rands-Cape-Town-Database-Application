package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gig;
import static org.junit.jupiter.api.Assertions.*;

class GigFactoryTest {

    @Test
    void createGig_Success() {
        Gig gig = GigFactory.createGig(1, 5000.0, "Cape Town Stadium");
        assertNotNull(gig);
        assertEquals(1, gig.getGigId());
    }

    @Test
    void createGig_Failure() {
        Gig gig = GigFactory.createGig(0, 0, "");
        assertNull(gig);
    }
}


    


