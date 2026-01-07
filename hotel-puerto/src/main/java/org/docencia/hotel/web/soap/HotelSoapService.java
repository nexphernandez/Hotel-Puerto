package org.docencia.hotel.web.soap;

import org.docencia.hotel.domain.model.Hotel;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(
        name = "HotelSoapService",
        targetNamespace = "http://hotel.docencia.org/ws"
)
public interface HotelSoapService {

    @WebMethod(operationName = "GetHotelById")
    @WebResult(name = "hotel")
    Hotel getHotelById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "SaveHotel")
    @WebResult(name = "hotel")
    Hotel saveHotel(@WebParam(name = "hotel") Hotel hotel);
}
