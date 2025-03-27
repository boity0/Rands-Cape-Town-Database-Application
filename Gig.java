package za.ac.cput.domain;

import java.util.Objects;

public class Gig {
    private int gigId;
    private double gigSalary;
    private String gigVenue;

    private Gig(Builder builder) {
        this.gigId = builder.gigId;
        this.gigSalary = builder.gigSalary;
        this.gigVenue = builder.gigVenue;
    }

    public int getGigId() {
        return gigId;
    }

    public double getGigSalary() {
        return gigSalary;
    }

    public String getGigVenue() {
        return gigVenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gig gig = (Gig) o;
        return gigId == gig.gigId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gigId);
    }

    @Override
    public String toString() {
        return "Gig{" +
                "gigId=" + gigId +
                ", gigSalary=" + gigSalary +
                ", gigVenue='" + gigVenue + '\'' +
                '}';
    }

    public static class Builder {
        private int gigId;
        private double gigSalary;
        private String gigVenue;

        public Builder setGigId(int gigId) {
            this.gigId = gigId;
            return this;
        }

        public Builder setGigSalary(double gigSalary) {
            this.gigSalary = gigSalary;
            return this;
        }

        public Builder setGigVenue(String gigVenue) {
            this.gigVenue = gigVenue;
            return this;
        }

        public Gig build() {
            return new Gig(this);
        }
    }
}
