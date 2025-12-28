package org.docencia.hotel.mapper.jpa;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
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
    date = "2025-12-28T17:12:07+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
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
        roomEntity.setBookings( bookingSetToBookingEntitySet( domain.getBookings() ) );

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

    protected HotelEntity hotelToHotelEntity(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.id( hotel.getId() );
        hotelEntity.name( hotel.getName() );
        hotelEntity.address( hotel.getAddress() );
        hotelEntity.rooms( toEntity( hotel.getRooms() ) );

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

    protected GuestPreferencesDocument guestPreferencesToGuestPreferencesDocument(GuestPreferences guestPreferences) {
        if ( guestPreferences == null ) {
            return null;
        }

        GuestPreferencesDocument guestPreferencesDocument = new GuestPreferencesDocument();

        guestPreferencesDocument.setGuestId( guestPreferences.getGuestId() );
        guestPreferencesDocument.setPreferredLanguage( guestPreferences.getPreferredLanguage() );
        List<String> list = guestPreferences.getTags();
        if ( list != null ) {
            guestPreferencesDocument.setTags( new ArrayList<String>( list ) );
        }
        guestPreferencesDocument.setFavoriteRoomType( guestPreferences.getFavoriteRoomType() );
        guestPreferencesDocument.setNotes( guestPreferences.getNotes() );

        return guestPreferencesDocument;
    }

    protected GuestEntity guestToGuestEntity(Guest guest) {
        if ( guest == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setId( guest.getId() );
        guestEntity.setFullName( guest.getFullName() );
        guestEntity.setEmail( guest.getEmail() );
        guestEntity.setPhone( guest.getPhone() );
        guestEntity.setBookings( bookingSetToBookingEntitySet( guest.getBookings() ) );
        guestEntity.setPreference( guestPreferencesToGuestPreferencesDocument( guest.getPreference() ) );

        return guestEntity;
    }

    protected BookingEntity bookingToBookingEntity(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId( booking.getId() );
        bookingEntity.setRoomId( toEntity( booking.getRoomId() ) );
        bookingEntity.setGuestId( guestToGuestEntity( booking.getGuestId() ) );
        bookingEntity.setCheckIn( booking.getCheckIn() );
        bookingEntity.setCheckOut( booking.getCheckOut() );

        return bookingEntity;
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

    protected GuestPreferences guestPreferencesDocumentToGuestPreferences(GuestPreferencesDocument guestPreferencesDocument) {
        if ( guestPreferencesDocument == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        guestPreferences.setGuestId( guestPreferencesDocument.getGuestId() );
        guestPreferences.setPreferredLanguage( guestPreferencesDocument.getPreferredLanguage() );
        List<String> list = guestPreferencesDocument.getTags();
        if ( list != null ) {
            guestPreferences.setTags( new ArrayList<String>( list ) );
        }
        guestPreferences.setFavoriteRoomType( guestPreferencesDocument.getFavoriteRoomType() );
        guestPreferences.setNotes( guestPreferencesDocument.getNotes() );

        return guestPreferences;
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
        guest.setPreference( guestPreferencesDocumentToGuestPreferences( guestEntity.getPreference() ) );

        return guest;
    }

    protected Booking bookingEntityToBooking(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( bookingEntity.getId() );
        booking.setRoomId( toDomain( bookingEntity.getRoomId() ) );
        booking.setGuestId( guestEntityToGuest( bookingEntity.getGuestId() ) );
        booking.setCheckIn( bookingEntity.getCheckIn() );
        booking.setCheckOut( bookingEntity.getCheckOut() );

        return booking;
    }
}
