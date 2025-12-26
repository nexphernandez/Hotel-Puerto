package org.docencia.hotel.persistence.jpa.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomId;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private GuestEntity guestId;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

    /**
     * Constructor vacio de la clase bookingEntity
     */
    public BookingEntity() {
    }

    /**
     * Constructor con el identificador de la clase bookingEntity
     *
     * @param id
     */
    public BookingEntity(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los atributos de la clase bookingEntity
     *
     * @param id identificador de la reserva
     * @param roomId identificador de la habitacion de la reserva
     * @param guestId identificador de huesped de la reserva
     * @param checkIn fecha y hora de entrada de la reserva
     * @param checkOut fecha y hora de salida de la reserva
     */
    public BookingEntity(Long id, RoomEntity roomId, GuestEntity guestId, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.roomId = roomId;
        this.guestId = guestId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomEntity getRoomId() {
        return this.roomId;
    }

    public void setRoomId(RoomEntity roomId) {
        this.roomId = roomId;
    }

    public GuestEntity getGuestId() {
        return this.guestId;
    }

    public void setGuestId(GuestEntity guestId) {
        this.guestId = guestId;
    }

    public LocalDate getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BookingEntity)) {
            return false;
        }
        BookingEntity bookingEntity = (BookingEntity) o;
        return Objects.equals(id, bookingEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", roomId='" + getRoomId() + "'"
                + ", guestId='" + getGuestId() + "'"
                + ", checkIn='" + getCheckIn() + "'"
                + ", checkOut='" + getCheckOut() + "'"
                + "}";
    }

}
