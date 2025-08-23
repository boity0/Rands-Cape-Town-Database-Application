package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Gig;

import java.util.List;

@RestController
@RequestMapping("/gig")
public class GigController {

    private final GigService service;

    @Autowired
    public GigController(GigService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Gig> create(@RequestBody Gig gig) {
        return ResponseEntity.ok(service.create(gig));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Gig> read(@PathVariable Long id) {
        return service.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<Gig> update(@RequestBody Gig gig) {
        return ResponseEntity.ok(service.update(gig));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gig>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
