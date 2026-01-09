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
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelEntity toEntity(Hotel domain) {
        if ( domain == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( domain.getId() );
        hotelEntity.setName( domain.getName() );
        hotelEntity.setAddress( domain.getAddress() );

        return hotelEntity;
    }

    @Override
    public Hotel toDomain(HotelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setId( entity.getId() );
        hotel.setName( entity.getName() );
        hotel.setAddress( entity.getAddress() );
        hotel.setRooms( roomEntitySetToRoomSet( entity.getRooms() ) );

        return hotel;
    }

    @Override
    public Set<Hotel> toDomain(Set<HotelEntity> bookings) {
        if ( bookings == null ) {
            return null;
        }

        Set<Hotel> set = new LinkedHashSet<Hotel>( Math.max( (int) ( bookings.size() / .75f ) + 1, 16 ) );
        for ( HotelEntity hotelEntity : bookings ) {
            set.add( toDomain( hotelEntity ) );
        }

        return set;
    }

    @Override
    public Set<HotelEntity> toEntity(Set<Hotel> bookings) {
        if ( bookings == null ) {
            return null;
        }

        Set<HotelEntity> set = new LinkedHashSet<HotelEntity>( Math.max( (int) ( bookings.size() / .75f ) + 1, 16 ) );
        for ( Hotel hotel : bookings ) {
            set.add( toEntity( hotel ) );
        }

        return set;
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
        booking.setRoom( roomEntityToRoom( bookingEntity.getRoom() ) );
        booking.setGuest( guestEntityToGuest( bookingEntity.getGuest() ) );
        booking.setCheckIn( bookingEntity.getCheckIn() );
        booking.setCheckOut( bookingEntity.getCheckOut() );

        return booking;
    }

    protected Room roomEntityToRoom(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( roomEntity.getId() );
        room.setNumber( roomEntity.getNumber() );
        room.setType( roomEntity.getType() );
        room.setPricePerNight( roomEntity.getPricePerNight() );
        room.setHotel( toDomain( roomEntity.getHotel() ) );
        room.setBookings( bookingEntitySetToBookingSet( roomEntity.getBookings() ) );

        return room;
    }

    protected Set<Room> roomEntitySetToRoomSet(Set<RoomEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<Room> set1 = new LinkedHashSet<Room>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoomEntity roomEntity : set ) {
            set1.add( roomEntityToRoom( roomEntity ) );
        }

        return set1;
    }
}
