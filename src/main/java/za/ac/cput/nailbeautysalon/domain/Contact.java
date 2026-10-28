package za.ac.cput.nailbeautysalon.domain;
/* Contact.java
   Contact POJO class
   Author: M Hlaba (223031437)
   Date: 22 June 2026 */
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;

import java.time.LocalTime;

@Entity
@IdClass(AddressId.class)
public class Contact {

    @Id
    @Column(length = 20)
    private String streetNumber;

    @Id
    @Column(length = 100)
    private String streetName;

    @Id
    @Column(length = 80)
    private String city;

    @Id
    @Column(length = 80)
    private String suburb;

    @Id
    @Column(length = 60)
    private String province;

    @Id
    @Column(length = 20)
    private int postalCode;

    @OneToOne
    private Address address;
    private String phone;
    private String email;
    private LocalTime hours;

    protected Contact(){}

    public Contact(Builder builder){
        this.address = builder.address;

        if (builder.address != null) {
            this.streetNumber = builder.address.getStreetNumber();
            this.streetName = builder.address.getStreetName();
            this.city = builder.address.getCity();
            this.suburb = builder.address.getSuburb();
            this.province = builder.address.getProvince();
            this.postalCode = builder.address.getPostalCode();
        }

        this.hours = builder.hours;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalTime getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address=" + address +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", hours=" + hours +
                '}';
    }

    public static class Builder{
        private Address address;
        private String phone;
        private String email;
        private LocalTime hours;

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setHours(LocalTime hours) {
            this.hours = hours;
            return this;
        }

        public Builder copy(Contact contact){
            this.address = contact.address;
            this.hours = contact.hours;
            this.email = contact.email;
            this.phone = contact.phone;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }
}
