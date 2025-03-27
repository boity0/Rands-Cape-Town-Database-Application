package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gig;
import za.ac.cput.factory.GigFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class GigRepositoryTest {
    private GigRepository repository;
    private Gig gig;

    @BeforeEach
    void setUp() {
        repository = GigRepository.getInstance();
        gig = GigFactory.createGig(1, 5000.0, "Cape Town Stadium");
        repository.create(gig);
    }

    @Test
    void create() {
        Gig newGig = GigFactory.createGig(2, 7000.0, "Johannesburg Arena");
        Gig created = repository.create(newGig);
        assertNotNull(created);
        assertEquals(2, created.getGigId());
    }

    @Test
    void read() {
        Gig foundGig = repository.read(1);
        assertNotNull(foundGig);
        assertEquals(1, foundGig.getGigId());
    }

    @Test
    void update() {
        Gig updatedGig = new Gig.Builder().setGigId(1).setGigSalary(6000.0).setGigVenue("New Venue").build();
        Gig updated = repository.update(updatedGig);
        assertNotNull(updated);
        assertEquals("New Venue", updated.getGigVenue());
    }

    @Test
    void delete() {
        assertTrue(repository.delete(1));
        assertNull(repository.read(1));
    }

    @Test
    void getAll() {
        Set<Gig> gigs = repository.getAll();
        assertFalse(gigs.isEmpty());
    }
}
