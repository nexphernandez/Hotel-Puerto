package org.docencia.hotel.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Booking {
    private Long id;

    private Room room;

    private Guest guest;

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
     * @param room identificador de la habitacion de la reserva
     * @param guest identificador de huesped de la reserva
     * @param checkIn fecha y hora de entrada de la reserva
     * @param checkOut fecha y hora de salida de la reserva
     */
    public Booking(Long id, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
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
            ", roomId='" + getRoom() + "'" +
            ", guestId='" + getGuest() + "'" +
            ", checkIn='" + getCheckIn() + "'" +
            ", checkOut='" + getCheckOut() + "'" +
            "}";
    }


    
}
