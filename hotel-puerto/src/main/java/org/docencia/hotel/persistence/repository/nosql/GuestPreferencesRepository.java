package org.docencia.hotel.persistence.repository.nosql;

import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz para hacer el contrato con Mongo
 */
@Repository
public interface GuestPreferencesRepository extends MongoRepository<GuestPreferencesDocument, Long>{
}
