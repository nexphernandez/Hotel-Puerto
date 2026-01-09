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
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-09T15:31:29+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Ubuntu)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public GuestEntity toEntity(Guest domain) {
        if ( domain == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setId( domain.getId() );
        guestEntity.setFullName( domain.getFullName() );
        guestEntity.setEmail( domain.getEmail() );
        guestEntity.setPhone( domain.getPhone() );
        guestEntity.setBookings( bookingSetToBookingEntitySet( domain.getBookings() ) );

        return guestEntity;
    }

    @Override
    public Guest toDomain(GuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( entity.getId() );
        guest.setFullName( entity.getFullName() );
        guest.setEmail( entity.getEmail() );
        guest.setPhone( entity.getPhone() );
        guest.setBookings( bookingEntitySetToBookingSet( entity.getBookings() ) );

        return guest;
    }

    @Override
    public Guest toDomain(GuestEntity entity, GuestPreferencesDocument guest) {
        if ( entity == null && guest == null ) {
            return null;
        }

        Guest guest1 = new Guest();

        if ( entity != null ) {
            guest1.setId( entity.getId() );
            guest1.setFullName( entity.getFullName() );
            guest1.setEmail( entity.getEmail() );
            guest1.setPhone( entity.getPhone() );
            guest1.setBookings( bookingEntitySetToBookingSet( entity.getBookings() ) );
        }

        return guest1;
    }

    @Override
    public Set<Guest> toDomain(Set<GuestEntity> bookings) {
        if ( bookings == null ) {
            return null;
        }

        Set<Guest> set = new LinkedHashSet<Guest>( Math.max( (int) ( bookings.size() / .75f ) + 1, 16 ) );
        for ( GuestEntity guestEntity : bookings ) {
            set.add( toDomain( guestEntity ) );
        }

        return set;
    }

    @Override
    public Set<GuestEntity> toEntity(Set<Guest> bookings) {
        if ( bookings == null ) {
            return null;
        }

        Set<GuestEntity> set = new LinkedHashSet<GuestEntity>( Math.max( (int) ( bookings.size() / .75f ) + 1, 16 ) );
        for ( Guest guest : bookings ) {
            set.add( toEntity( guest ) );
        }

        return set;
    }

    protected Set<RoomEntity> roomSetToRoomEntitySet(Set<Room> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoomEntity> set1 = new LinkedHashSet<RoomEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Room room : set ) {
            set1.add( roomToRoomEntity( room ) );
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

    protected Set<BookingEntity> bookingSetToBookingEntitySet(Set<Booking> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookingEntity> set1 = new LinkedHashSet<BookingEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Booking booking : set ) {
            set1.add( bookingToBookingEntity( booking ) );
        }

        return set1;
    }

    protected RoomEntity roomToRoomEntity(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setId( room.getId() );
        roomEntity.setNumber( room.getNumber() );
        roomEntity.setType( room.getType() );
        roomEntity.setPricePerNight( room.getPricePerNight() );
        roomEntity.setHotel( hotelToHotelEntity( room.getHotel() ) );
        roomEntity.setBookings( bookingSetToBookingEntitySet( room.getBookings() ) );

        return roomEntity;
    }

    protected BookingEntity bookingToBookingEntity(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId( booking.getId() );
        bookingEntity.setRoom( roomToRoomEntity( booking.getRoom() ) );
        bookingEntity.setGuest( toEntity( booking.getGuest() ) );
        bookingEntity.setCheckIn( booking.getCheckIn() );
        bookingEntity.setCheckOut( booking.getCheckOut() );

        return bookingEntity;
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

    protected Room roomEntityToRoom(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( roomEntity.getId() );
        room.setNumber( roomEntity.getNumber() );
        room.setType( roomEntity.getType() );
        room.setPricePerNight( roomEntity.getPricePerNight() );
        room.setHotel( hotelEntityToHotel( roomEntity.getHotel() ) );
        room.setBookings( bookingEntitySetToBookingSet( roomEntity.getBookings() ) );

        return room;
    }

    protected Booking bookingEntityToBooking(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( bookingEntity.getId() );
        booking.setRoom( roomEntityToRoom( bookingEntity.getRoom() ) );
        booking.setGuest( toDomain( bookingEntity.getGuest() ) );
        booking.setCheckIn( bookingEntity.getCheckIn() );
        booking.setCheckOut( bookingEntity.getCheckOut() );

        return booking;
    }
}
