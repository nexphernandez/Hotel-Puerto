package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-29T13:19:49+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Autowired
    private GuestPreferencesMapper guestPreferencesMapper;

    @Override
    public GuestEntity toEntity(Guest domain) {
        if ( domain == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setPreference( guestPreferencesMapper.toDocument( domain.getPreference() ) );
        guestEntity.setId( domain.getId() );
        guestEntity.setFullName( domain.getFullName() );
        guestEntity.setEmail( domain.getEmail() );
        guestEntity.setPhone( domain.getPhone() );

        return guestEntity;
    }

    @Override
    public Guest toDomain(GuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setPreference( guestPreferencesMapper.toDomain( entity.getPreference() ) );
        guest.setId( entity.getId() );
        guest.setFullName( entity.getFullName() );
        guest.setEmail( entity.getEmail() );
        guest.setPhone( entity.getPhone() );

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
        }
        guest1.setPreference( guestPreferencesMapper.toDomain( guest ) );

        return guest1;
    }
}
