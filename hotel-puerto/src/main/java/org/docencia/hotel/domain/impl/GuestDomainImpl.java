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
        return service.existsById(id);
    }

    @Override
    public Guest findById(Long id) {
        return service.findById(id);
    }

    @Override
    public Set<Guest> findAll() {
        return service.findAll();
    }

    @Override
    public Guest save(Guest guest) {
        return service.save(guest);
    }

    @Override
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }

    @Override
    public GuestPreferences savePreferences(Long guestId, GuestPreferences preferences) {
        return service.savePreferences(guestId, preferences);
    }

    @Override
    public boolean deletePreferenceById(Long guestId) {
        return service.deletePreferenceById(guestId);
    }

    @Override
    public GuestPreferences findPreferenceById(Long guestId) {
        return service.findPreferenceById(guestId);
    }
}
