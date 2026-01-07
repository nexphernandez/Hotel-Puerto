package org.docencia.hotel.domain.impl;

import java.util.Set;

import org.docencia.hotel.domain.api.BookingDomain;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Clase de implemntacion de los metodos de Booking
 */
@Service
public class BookingDomainImpl implements BookingDomain {

    private final BookingService service;

    public BookingDomainImpl(BookingService service) {
        this.service = service;
    }

    @Override
    public boolean existsById(Long id) {
        verificarId(id);
        return  service.existsById(id);
    }

    @Override
    public Booking findById(Long id) {
        verificarId(id);
        return service.findById(id);
    }

    @Override
    public Set<Booking> findAll() {
        return  service.findAll();
    }

    @Override
    public Booking save(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula");
        }
        verificarId(booking.getId());
        return service.save(booking);
    }

    @Override
    public boolean deleteById(Long id) {
        verificarId(id);
        return service.deleteById(id);
    }

    @Override
    public Booking findByRoomIdAndDateRange(Long roomId, String checkin, String checkout) {
        verificarId(roomId);
        return service.findByRoomIdAndDateRange(roomId, checkin, checkout);
    }

    public void verificarId (Long id){
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    }
}
