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
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private GuestEntity guest;

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
    public BookingEntity(Long id, RoomEntity room, GuestEntity guest, LocalDate checkIn, LocalDate checkOut) {
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

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public GuestEntity getGuest() {
        return guest;
    }

    public void setGuest(GuestEntity guest) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("BookingEntity{");
        sb.append("id=").append(id);
        sb.append(", room=").append(room);
        sb.append(", guest=").append(guest);
        sb.append(", checkIn=").append(checkIn);
        sb.append(", checkOut=").append(checkOut);
        sb.append('}');
        return sb.toString();
    }



}
