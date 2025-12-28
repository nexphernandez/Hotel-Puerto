package org.docencia.hotel.mapper.jpa;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-28T19:31:13+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomEntity toEntity(Room domain) {
        if ( domain == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setHotel( hotelToHotelEntity( domain.getHotel() ) );
        roomEntity.setId( domain.getId() );
        roomEntity.setNumber( domain.getNumber() );
        roomEntity.setType( domain.getType() );
        roomEntity.setPricePerNight( domain.getPricePerNight() );

        return roomEntity;
    }

    @Override
    public Room toDomain(RoomEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Room room = new Room();

        room.setHotel( hotelEntityToHotel( entity.getHotel() ) );
        room.setId( entity.getId() );
        room.setNumber( entity.getNumber() );
        room.setType( entity.getType() );
        room.setPricePerNight( entity.getPricePerNight() );

        return room;
    }

    protected Set<RoomEntity> roomSetToRoomEntitySet(Set<Room> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoomEntity> set1 = new LinkedHashSet<RoomEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Room room : set ) {
            set1.add( toEntity( room ) );
        }

        return set1;
    }

    protected HotelEntity hotelToHotelEntity(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( hotel.getId() );
        hotelEntity.setName( hotel.getName() );
        hotelEntity.setAddress( hotel.getAddress() );
        hotelEntity.setRooms( roomSetToRoomEntitySet( hotel.getRooms() ) );

        return hotelEntity;
    }

    protected Set<Room> roomEntitySetToRoomSet(Set<RoomEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<Room> set1 = new LinkedHashSet<Room>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoomEntity roomEntity : set ) {
            set1.add( toDomain( roomEntity ) );
        }

        return set1;
    }

    protected Hotel hotelEntityToHotel(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setId( hotelEntity.getId() );
        hotel.setName( hotelEntity.getName() );
        hotel.setAddress( hotelEntity.getAddress() );
        hotel.setRooms( roomEntitySetToRoomSet( hotelEntity.getRooms() ) );

        return hotel;
    }
}
