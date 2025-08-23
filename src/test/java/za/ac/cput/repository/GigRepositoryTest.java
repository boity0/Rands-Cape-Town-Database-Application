package za.ac.cput.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Gig;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GigRepositoryTest {

    @Autowired
    private GigRepository repository;

    @Test
    void testSaveAndFind() {
        Gig gig = new Gig.Builder()
                .setGigVenue("Cape Town")
                .setGigFee(400.0)
                .build();

        Gig saved = repository.save(gig);
        assertNotNull(saved.getGigId());

        Optional<Gig> found = repository.findById(saved.getGigId());
        assertTrue(found.isPresent());
        assertEquals("Cape Town", found.get().getGigVenue());
    }
}

