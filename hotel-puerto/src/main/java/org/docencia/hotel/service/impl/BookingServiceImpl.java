package org.docencia.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.persistence.repository.jpa.BookingRepository;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz con los metodos a realizar
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final BookingMapper mapper;
    
    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
    
    @Override
    public Booking findById(Long id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }
    
    @Override
    public Set<Booking> findAll() {
        return mapper.toDomain(new HashSet<>(repository.findAll()));
    }
    
    @Override
    public boolean deleteById(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
    
    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null) {
            booking.setId(UUID.randomUUID().getLeastSignificantBits());
        }
        return mapper.toDomain(repository.save(mapper.toEntity(booking)));
    }
    
    @Override
    public Booking findByRoomIdAndDateRange(Long roomId, String startDate, String endDate) {
        List<Booking> bookings = new ArrayList<>( repository.findByRoomIdAndDateRange(roomId, startDate, endDate));
        return bookings.get(0);
    }
    
}
