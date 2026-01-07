package org.docencia.hotel.web.soap;

import org.docencia.hotel.domain.model.Booking;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(
        name = "BookingSoapService",
        targetNamespace = "http://hotel.docencia.org/ws"
)
public interface BookingSoapService {

    @WebMethod(operationName = "GetBookingById")
    @WebResult(name = "booking")
    Booking getBookingById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "saveBooking")
    @WebResult(name = "booking")
    Booking saveBooking(@WebParam(name = "booking") Booking booking);
}
