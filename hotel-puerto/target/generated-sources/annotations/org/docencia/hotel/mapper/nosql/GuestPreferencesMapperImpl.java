package org.docencia.hotel.mapper.nosql;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-28T17:07:42+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class GuestPreferencesMapperImpl implements GuestPreferencesMapper {

    @Override
    public GuestPreferencesDocument toDocument(GuestPreferences domain) {
        if ( domain == null ) {
            return null;
        }

        GuestPreferencesDocument guestPreferencesDocument = new GuestPreferencesDocument();

        guestPreferencesDocument.setGuestId( domain.getGuestId() );
        guestPreferencesDocument.setPreferredLanguage( domain.getPreferredLanguage() );
        List<String> list = domain.getTags();
        if ( list != null ) {
            guestPreferencesDocument.setTags( new ArrayList<String>( list ) );
        }
        guestPreferencesDocument.setFavoriteRoomType( domain.getFavoriteRoomType() );
        guestPreferencesDocument.setNotes( domain.getNotes() );

        return guestPreferencesDocument;
    }

    @Override
    public GuestPreferences toDomain(GuestPreferencesDocument doc) {
        if ( doc == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        guestPreferences.setGuestId( doc.getGuestId() );
        guestPreferences.setPreferredLanguage( doc.getPreferredLanguage() );
        List<String> list = doc.getTags();
        if ( list != null ) {
            guestPreferences.setTags( new ArrayList<String>( list ) );
        }
        guestPreferences.setFavoriteRoomType( doc.getFavoriteRoomType() );
        guestPreferences.setNotes( doc.getNotes() );

        return guestPreferences;
    }
}
