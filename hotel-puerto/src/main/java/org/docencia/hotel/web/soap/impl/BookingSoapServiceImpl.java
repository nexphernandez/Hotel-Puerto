package org.docencia.hotel.web.soap.impl;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.web.soap.GuestSoapService;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;

@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.BookingSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "BookingSoapService",
        portName = "BookingSoapPort"
)
public class BookingSoapServiceImpl implements GuestSoapService {

    private final GuestDomain guestDomain;

    public GuestSoapServiceImpl(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }
}
