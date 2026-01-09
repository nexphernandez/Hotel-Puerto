package org.docencia.hotel.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Guest {

    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private Set<Booking> bookings;


    /**
     * Constructor vacio de la clase Guest
     */
    public Guest() {
    }

    /**
     * Constructor con el identificador de la clase Guest
     * @param id identificador del huesped
     */
    public Guest(Long id) {
        this.id = id;
    }

    /**
     * Constructor con los atributos de la clase Guest
     * @param id identificador del huesped
     * @param fullName nombre completo del huesped
     * @param email email del huesped
     * @param phone telefono del huesped
     * @param bookings reservas del huesped
     */
    public Guest(Long id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.bookings = new HashSet<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Guest)) {
            return false;
        }
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", bookings='" + getBookings() + "'" +
            "}";
    }
   
}
