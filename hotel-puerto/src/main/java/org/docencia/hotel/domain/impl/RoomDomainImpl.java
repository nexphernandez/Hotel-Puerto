package org.docencia.hotel.domain.impl;

import java.util.Set;

import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Clase de implemntacion de los metodos de Room
 */
@Service
public class RoomDomainImpl implements RoomDomain {

    private final RoomService service;

    public RoomDomainImpl(RoomService service) {
        this.service = service;
    }

    public void verificarId (Long id){
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    }

    @Override
    public boolean existsById(Long id) {
        verificarId(id);
        return service.existsById(id);
    }

    @Override
    public Room findById(Long id) {
        verificarId(id);
        return service.findById(id);
    }

    @Override
    public Set<Room> findAll() {
        return service.findAll();
    }

    @Override
    public Room save(Room room) {
        verificarId(room.getId());
        return service.save(room);

    }

    @Override
    public boolean deleteById(Long id) {
        verificarId(id);
        return service.deleteById(id);
    }

    @Override
    public Room findByHotelId(Long hotelId) {
        verificarId(hotelId);
        return service.findByHotelId(hotelId);
    }
}
