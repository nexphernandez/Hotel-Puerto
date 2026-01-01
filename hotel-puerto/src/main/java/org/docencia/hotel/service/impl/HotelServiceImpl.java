package org.docencia.hotel.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz con los metodos a realizar
 */
@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;
    private final HotelMapper mapper;
    
    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

     @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Hotel findById(Long id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }

    @Override
    public Set<Hotel> findAll() {
        return mapper.toDomain(new HashSet<>(repository.findAll()));
    }

    @Override
    @Transactional
    public Hotel save(Hotel hotel) {
        if (hotel.getId() == null) {
            hotel.setId(UUID.randomUUID().getLeastSignificantBits());
        }
        return mapper.toDomain(repository.save(mapper.toEntity(hotel)));
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
