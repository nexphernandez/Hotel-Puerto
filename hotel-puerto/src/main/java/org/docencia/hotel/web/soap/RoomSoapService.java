package org.docencia.hotel.web.soap;

import org.docencia.hotel.domain.model.Room;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(
        name = "RoomSoapService",
        targetNamespace = "http://hotel.docencia.org/ws"
)
public interface RoomSoapService {

    @WebMethod(operationName = "GetRoomById")
    @WebResult(name = "room")
    Room getRoomById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "SaveRoom")
    @WebResult(name = "room")
    Room saveRoom(@WebParam(name = "room") Room room);
}
