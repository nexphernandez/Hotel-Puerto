package org.docencia.hotel.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;
    private final RoomMapper mapper;
    
    public RoomServiceImpl(RoomRepository repository, RoomMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Room findById(Long id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }

    @Override
    public Set<Room> findAll() {
        return mapper.toDomain(new HashSet<>(repository.findAll()));
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

    @Override    
    @Transactional
    public Room save(Room room) {
        if (room.getId() == null) {
            room.setId(UUID.randomUUID().getLeastSignificantBits());
        }
        return mapper.toDomain(repository.save(mapper.toEntity(room)));
    }

    @Override
    public Room findByHotelId(Long hotelId) {
        return mapper.toDomain(repository.findByHotelId(hotelId).get(0));
    }
}
