package org.docencia.hotel.persistence.repository.jpa;

import java.util.Set;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz para hacer el contrato con Jpa
 */
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long>{
    Set<Room> findByHotelId(String id);
}
