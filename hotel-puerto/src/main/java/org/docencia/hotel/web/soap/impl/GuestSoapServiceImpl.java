package org.docencia.hotel.web.soap.impl;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
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
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Guest saveGuest(Guest guest) {
        throw new UnsupportedOperationException("TODO");
    }
}
