package org.docencia.hotel.mapper.jpa;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-09T15:31:29+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Ubuntu)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomEntity toEntity(Room domain) {
        if ( domain == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setId( domain.getId() );
        roomEntity.setNumber( domain.getNumber() );
        roomEntity.setType( domain.getType() );
        roomEntity.setPricePerNight( domain.getPricePerNight() );
        roomEntity.setHotel( hotelToHotelEntity( domain.getHotel() ) );

        return roomEntity;
    }

    @Override
    public Room toDomain(RoomEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( entity.getId() );
        room.setNumber( entity.getNumber() );
        room.setType( entity.getType() );
        room.setPricePerNight( entity.getPricePerNight() );
        room.setHotel( hotelEntityToHotel( entity.getHotel() ) );
        room.setBookings( bookingEntitySetToBookingSet( entity.getBookings() ) );

        return room;
    }

    @Override
    public Set<Room> toDomain(Set<RoomEntity> bookings) {
        if ( bookings == null ) {
            return null;
        }

        Set<Room> set = new LinkedHashSet<Room>( Math.max( (int) ( bookings.size() / .75f ) + 1, 16 ) );
        for ( RoomEntity roomEntity : bookings ) {
            set.add( toDomain( roomEntity ) );
        }

        return set;
    }

    @Override
    public Set<RoomEntity> toEntity(Set<Room> bookings) {
        if ( bookings == null ) {
            return null;
        }

        Set<RoomEntity> set = new LinkedHashSet<RoomEntity>( Math.max( (int) ( bookings.size() / .75f ) + 1, 16 ) );
        for ( Room room : bookings ) {
            set.add( toEntity( room ) );
        }

        return set;
    }

    protected HotelEntity hotelToHotelEntity(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( hotel.getId() );
        hotelEntity.setName( hotel.getName() );
        hotelEntity.setAddress( hotel.getAddress() );
        hotelEntity.setRooms( toEntity( hotel.getRooms() ) );

        return hotelEntity;
    }

    protected Hotel hotelEntityToHotel(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setId( hotelEntity.getId() );
        hotel.setName( hotelEntity.getName() );
        hotel.setAddress( hotelEntity.getAddress() );
        hotel.setRooms( toDomain( hotelEntity.getRooms() ) );

        return hotel;
    }

    protected Set<Booking> bookingEntitySetToBookingSet(Set<BookingEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<Booking> set1 = new LinkedHashSet<Booking>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BookingEntity bookingEntity : set ) {
            set1.add( bookingEntityToBooking( bookingEntity ) );
        }

        return set1;
    }

    protected Guest guestEntityToGuest(GuestEntity guestEntity) {
        if ( guestEntity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( guestEntity.getId() );
        guest.setFullName( guestEntity.getFullName() );
        guest.setEmail( guestEntity.getEmail() );
        guest.setPhone( guestEntity.getPhone() );
        guest.setBookings( bookingEntitySetToBookingSet( guestEntity.getBookings() ) );

        return guest;
    }

    protected Booking bookingEntityToBooking(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( bookingEntity.getId() );
        booking.setRoom( toDomain( bookingEntity.getRoom() ) );
        booking.setGuest( guestEntityToGuest( bookingEntity.getGuest() ) );
        booking.setCheckIn( bookingEntity.getCheckIn() );
        booking.setCheckOut( bookingEntity.getCheckOut() );

        return booking;
    }
}
