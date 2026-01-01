package org.docencia.hotel.persistence.repository.jpa;

import java.util.Set;

import org.docencia.hotel.domain.model.Booking;
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
    
    @Query("SELECT b FROM Booking as b WHERE b.room.id = :roomId " +
           "AND b.fechaSalida > :startDate AND b.fechaEntrada < :endDate")
    Set<Booking> findByRoomIdAndDateRange(
        @Param("roomId") Long roomId, 
        @Param("startDate") String startDate, 
        @Param("endDate") String endDate
    );
}
