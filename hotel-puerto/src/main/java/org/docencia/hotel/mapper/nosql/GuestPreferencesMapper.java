package org.docencia.hotel.mapper.nosql;

import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestPreferencesMapper {

    GuestPreferencesDocument toDocument(GuestPreferences domain);

    GuestPreferences toDomain(GuestPreferencesDocument doc);
}
