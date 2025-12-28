package org.docencia.hotel.persistence.jpa.entity;

import java.util.Objects;
import java.util.Set;

import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name = "guest")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "guest")
    private Set<BookingEntity> bookings;

    @Transient
    private GuestPreferencesDocument preference;

    /**
     * Constructor vacio de la clase GuestEntity
     */
    public GuestEntity() {
    }

    /**
     * Constructor con el identificador de la clase GuestEntity
     * @param id identificador del huesped
     */
    public GuestEntity(Long id) {
        this.id = id;
    }

    /**
     * Constructor con los atributos de la clase GuestEntity
     * @param id identificador del huesped
     * @param fullName nombre completo del huesped
     * @param email email del huesped
     * @param phone telefono del huesped
     * @param bookings reservas del huesped
     * @param preference preferencias del huesped
     */
    public GuestEntity(Long id, String fullName, String email, String phone, Set<BookingEntity> bookings, GuestPreferencesDocument preference) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.bookings = bookings;
        this.preference = preference;
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

    public Set<BookingEntity> getBookings() {
        return this.bookings;
    }

    public void setBookings(Set<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    public GuestPreferencesDocument getPreference() {
        return this.preference;
    }

    public void setPreference(GuestPreferencesDocument preference) {
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GuestEntity)) {
            return false;
        }
        GuestEntity guestEntity = (GuestEntity) o;
        return Objects.equals(id, guestEntity.id) ;
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
            ", preference='" + getPreference() + "'" +
            "}";
    }

}
