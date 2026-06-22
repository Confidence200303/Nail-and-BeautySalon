package za.ac.cput.nailbeautysalon.domain;

import java.time.LocalDateTime;

/* Appointment.java
Appointment model class
Author: Tshephiso Kekana (240264681)
Date: 22/06/2026
*/

public class Appointment {
    private String appointmentId;
    private LocalDateTime dateTime;
    private String serviceSelected;
    private Address address;
    private String status;
    private String notes;

    protected Appointment() {
    }

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.dateTime = builder.dateTime;
        this.serviceSelected = builder.serviceSelected;
        this.address = builder.address;
        this.status = builder.status;
        this.notes = builder.notes;

    }

    public String getServiceSelected() {
        return serviceSelected;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "address=" + address +
                ", appointmentId='" + appointmentId + '\'' +
                ", dateTime=" + dateTime +
                ", serviceSelected='" + serviceSelected + '\'' +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public static class Builder {
        private String appointmentId;
        private LocalDateTime dateTime;
        private String serviceSelected;
        private Address address;
        private String status;
        private String notes;


        public Builder SetAppoinmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder SetDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder SetServiceSelected(String serviceSelected) {
            this.serviceSelected = serviceSelected;
            return this;
        }

        public Builder SetAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder SetStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder SetNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder copy(Appointment appointment) {
            this.appointmentId = appointment.appointmentId;
            this.dateTime = appointment.dateTime;
            this.serviceSelected = appointment.serviceSelected;
            this.address = appointment.address;
            this.status = appointment.status;
            this.notes = appointment.notes;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
