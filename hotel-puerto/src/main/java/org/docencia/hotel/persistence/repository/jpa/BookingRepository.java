package org.docencia.hotel.persistence.repository.jpa;

import java.util.Set;

import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz para hacer el contrato con Jpa
 */
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{
    
    @Query("SELECT b FROM BookingEntity as b WHERE b.room.id = :roomId " +
    "AND b.checkOut > :checkIn AND b.checkIn < :checkOut")
    Set<BookingEntity> findByRoomIdAndDateRange(
        @Param("roomId") Long roomId, 
        @Param("checkIn") String checkIn, 
        @Param("checkOut") String checkOut
    );
}
