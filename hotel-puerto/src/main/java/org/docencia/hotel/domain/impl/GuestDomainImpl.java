package org.docencia.hotel.domain.impl;

import java.util.Set;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Clase de implemntacion de los metodos de Guest
 */
@Service
public class GuestDomainImpl implements GuestDomain {

    private final GuestService service;

    public GuestDomainImpl(GuestService service) {
        this.service = service;
    }

    @Override
    public boolean existsById(Long id) {
        verificarId(id);
        return service.existsById(id);
    }

    @Override
    public Guest findById(Long id) {
        verificarId(id);
        return service.findById(id);
    }

    @Override
    public Set<Guest> findAll() {
        return service.findAll();
    }

    @Override
    public Guest save(Guest guest) {
        if (guest == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");        
        }
        verificarId(guest.getId());
        return service.save(guest);
    }

    @Override
    public boolean deleteById(Long id) {
        verificarId(id);
        return service.deleteById(id);
    }

    @Override
    public GuestPreferences savePreferences(Long guestId, GuestPreferences preferences) {
        verificarId(guestId);
        return service.savePreferences(guestId, preferences);
    }

    @Override
    public boolean deletePreferenceById(Long guestId) {
        verificarId(guestId);
        return service.deletePreferenceById(guestId);
    }

    @Override
    public GuestPreferences findPreferenceById(Long guestId) {
        verificarId(guestId);
        return service.findPreferenceById(guestId);
    }

    public void verificarId (Long id){
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    }
}
