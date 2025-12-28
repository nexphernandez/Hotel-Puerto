package org.docencia.hotel.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Booking {
    private Long id;

    private Room roomId;

    private Guest guestId;

    private LocalDate checkIn;

    private LocalDate checkOut;

    /**
     * Constructor vacio de la clase booking
     */
    public Booking() {
    }

    /**
     * Constructor con el identificador de la clase booking
     *
     * @param id
     */
    public Booking(Long id) {
        this.id = id;
    }
    
    /**
     * Constructor con todos los atributos de la clase booking
     *
     * @param id identificador de la reserva
     * @param roomId identificador de la habitacion de la reserva
     * @param guestId identificador de huesped de la reserva
     * @param checkIn fecha y hora de entrada de la reserva
     * @param checkOut fecha y hora de salida de la reserva
     */
    public Booking(Long id, Room roomId, Guest guestId, LocalDate checkIn, LocalDate checkOut) {
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

    public Room getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Guest getGuestId() {
        return this.guestId;
    }

    public void setGuestId(Guest guestId) {
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
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", roomId='" + getRoomId() + "'" +
            ", guestId='" + getGuestId() + "'" +
            ", checkIn='" + getCheckIn() + "'" +
            ", checkOut='" + getCheckOut() + "'" +
            "}";
    }
    
}
