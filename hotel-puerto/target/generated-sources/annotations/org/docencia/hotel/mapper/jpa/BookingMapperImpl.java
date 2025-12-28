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
    date = "2025-12-28T19:31:12+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingEntity toEntity(Booking domain) {
        if ( domain == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setRoom( roomToRoomEntity( domain.getRoom() ) );
        bookingEntity.setGuest( guestToGuestEntity( domain.getGuest() ) );
        bookingEntity.setId( domain.getId() );
        bookingEntity.setCheckIn( domain.getCheckIn() );
        bookingEntity.setCheckOut( domain.getCheckOut() );

        return bookingEntity;
    }

    @Override
    public Booking toDomain(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setRoom( roomEntityToRoom( entity.getRoom() ) );
        booking.setGuest( guestEntityToGuest( entity.getGuest() ) );
        booking.setId( entity.getId() );
        booking.setCheckIn( entity.getCheckIn() );
        booking.setCheckOut( entity.getCheckOut() );

        return booking;
    }

    @Override
    public Set<Booking> toDomainList(Set<BookingEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        Set<Booking> set = new LinkedHashSet<Booking>( Math.max( (int) ( entities.size() / .75f ) + 1, 16 ) );
        for ( BookingEntity bookingEntity : entities ) {
            set.add( toDomain( bookingEntity ) );
        }

        return set;
    }

    @Override
    public Set<BookingEntity> toEntityList(Set<Booking> domains) {
        if ( domains == null ) {
            return null;
        }

        Set<BookingEntity> set = new LinkedHashSet<BookingEntity>( Math.max( (int) ( domains.size() / .75f ) + 1, 16 ) );
        for ( Booking booking : domains ) {
            set.add( toEntity( booking ) );
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
        roomEntity.setBookings( toEntityList( room.getBookings() ) );

        return roomEntity;
    }

    protected GuestPreferencesDocument guestPreferencesToGuestPreferencesDocument(GuestPreferences guestPreferences) {
        if ( guestPreferences == null ) {
            return null;
        }

        GuestPreferencesDocument guestPreferencesDocument = new GuestPreferencesDocument();

        guestPreferencesDocument.setGuestId( guestPreferences.getGuestId() );
        guestPreferencesDocument.setPreferredLanguage( guestPreferences.getPreferredLanguage() );
        guestPreferencesDocument.setNewsLetterOptIn( guestPreferences.getNewsLetterOptIn() );
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
        guestEntity.setBookings( toEntityList( guest.getBookings() ) );
        guestEntity.setPreference( guestPreferencesToGuestPreferencesDocument( guest.getPreference() ) );

        return guestEntity;
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
        room.setBookings( toDomainList( roomEntity.getBookings() ) );

        return room;
    }

    protected GuestPreferences guestPreferencesDocumentToGuestPreferences(GuestPreferencesDocument guestPreferencesDocument) {
        if ( guestPreferencesDocument == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        guestPreferences.setGuestId( guestPreferencesDocument.getGuestId() );
        guestPreferences.setPreferredLanguage( guestPreferencesDocument.getPreferredLanguage() );
        guestPreferences.setNewsLetterOptIn( guestPreferencesDocument.getNewsLetterOptIn() );
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
        guest.setBookings( toDomainList( guestEntity.getBookings() ) );
        guest.setPreference( guestPreferencesDocumentToGuestPreferences( guestEntity.getPreference() ) );

        return guest;
    }
}
