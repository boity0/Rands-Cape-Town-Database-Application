package za.ac.cput.domain;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gigId;

    @Column(nullable = false)
    private String gigVenue;

    @Column(nullable = false)
    private double gigFee;

    // Relationships
    @ManyToOne
    private DJ dj;

    @OneToOne
    private Timeslot timeslot;

    protected Gig() {} // JPA requires default constructor

    private Gig(Builder builder) {
        this.gigVenue = builder.gigVenue;
        this.gigFee = builder.gigFee;
        this.dj = builder.dj;
        this.timeslot = builder.timeslot;
    }

    // Getters
    public Long getGigId() { return gigId; }
    public String getGigVenue() { return gigVenue; }
    public double getGigFee() { return gigFee; }
    public DJ getDj() { return dj; }
    public Timeslot getTimeslot() { return timeslot; }

    // Builder pattern
    public static class Builder {
        private String gigVenue;
        private double gigFee;
        private DJ dj;
        private Timeslot timeslot;

        public Builder setGigVenue(String gigVenue) {
            this.gigVenue = gigVenue;
            return this;
        }

        public Builder setGigFee(double gigFee) {
            this.gigFee = gigFee;
            return this;
        }

        public Builder setDj(DJ dj) {
            this.dj = dj;
            return this;
        }

        public Builder setTimeslot(Timeslot timeslot) {
            this.timeslot = timeslot;
            return this;
        }

        public Builder copy(Gig gig) {
            this.gigVenue = gig.gigVenue;
            this.gigFee = gig.gigFee;
            this.dj = gig.dj;
            this.timeslot = gig.timeslot;
            return this;
        }

        public Gig build() {
            return new Gig(this);
        }
    }

    // toString for logging
    @Override
    public String toString() {
        return "Gig{" +
                "gigId=" + gigId +
                ", gigVenue='" + gigVenue + '\'' +
                ", gigFee=" + gigFee +
                ", dj=" + (dj != null ? dj.getDjName() : "none") +
                ", timeslot=" + (timeslot != null ? timeslot.toString() : "none") +
                '}';
    }

    // equals and hashCode for entity comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gig)) return false;
        Gig gig = (Gig) o;
        return Objects.equals(gigId, gig.gigId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gigId);
    }
}

