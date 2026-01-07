package org.docencia.hotel.web.soap.impl;

import java.util.Set;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.web.soap.GuestSoapService;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;

@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.GuestSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "GuestSoapService",
        portName = "GuestSoapPort"
)
public class GuestSoapServiceImpl implements GuestSoapService {

    private final GuestDomain guestDomain;

    public GuestSoapServiceImpl(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    @Override
    public Guest getGuestById(Long id) {
        return guestDomain.findById(id);
    }

    @Override
    public Guest saveGuest(Guest guest) {
        return  guestDomain.save(guest);
    }

    @Override
    public Set<Guest> findAllGuests() {
        return guestDomain.findAll();
    }

    @Override
    public boolean deleteGuestById(Long id) {
        return guestDomain.deleteById(id);
    }

    @Override
    public GuestPreferences saveGuestPreferences(Long guestId, GuestPreferences preferences) {
        if (!guestDomain.existsById(guestId)) {
            return null;
        }
        return  guestDomain.savePreferences(guestId, preferences);
    }

    @Override
    public boolean deletePreferenceById(Long guestId) {
        return guestDomain.deletePreferenceById(guestId);
    }

    @Override
    public GuestPreferences findPreferenceById(Long guestId) {
        return guestDomain.findPreferenceById(guestId);
    }
}
