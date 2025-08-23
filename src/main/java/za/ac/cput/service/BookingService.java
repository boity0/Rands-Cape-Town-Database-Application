package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    public Optional<Booking> read(Long id) {
        return repository.findById(id);
    }

    public Booking update(Booking booking) {
        return repository.save(booking);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Booking> getAll() {
        return repository.findAll();
    }
}

