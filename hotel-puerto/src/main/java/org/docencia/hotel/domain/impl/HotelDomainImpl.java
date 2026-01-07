package org.docencia.hotel.domain.impl;

import java.util.Set;

import org.docencia.hotel.domain.api.HotelDomain;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Clase de implemntacion de los metodos de Hotel
 */
@Service
public class HotelDomainImpl implements HotelDomain {

    private final HotelService service;

    public HotelDomainImpl(HotelService service) {
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
    public Hotel findById(Long id) {
        verificarId(id);
        return service.findById(id);
    }

    @Override
    public Set<Hotel> findAll() {
        return service.findAll();
    }

    @Override
    public Hotel save(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("El hotel no puede ser nulo");   
        }
        verificarId(hotel.getId());
        return service.save(hotel);
    }

    @Override
    public boolean deleteById(Long id) {
        verificarId(id);
        return service.deleteById(id);
    }
}
