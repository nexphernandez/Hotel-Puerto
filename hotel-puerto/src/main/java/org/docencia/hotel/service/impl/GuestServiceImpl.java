package org.docencia.hotel.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.docencia.hotel.persistence.repository.jpa.GuestJpaRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestJpaRepository repository;
    private final GuestMapper mapper;
    
    public GuestServiceImpl(GuestJpaRepository repository, GuestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Guest findById(Long id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }

    @Override
    public Set<Guest> findAll() {
        return mapper.toDomain(new HashSet<>(repository.findAll()));
    }

    @Override
    public Guest save(Guest guest) {
        if (guest.getId() == null ) {
            guest.setId(UUID.randomUUID().getLeastSignificantBits());
        }
        return mapper.toDomain(repository.save(mapper.toEntity(guest)));
    }

    @Override
    public GuestPreferences save(Long Id, GuestPreferencesDocument preferences) {
        preferences.setGuestId(Id);
        return mapper.toDomain(repository.save(preferences));
    }

    @Override
    public boolean deleteById(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
