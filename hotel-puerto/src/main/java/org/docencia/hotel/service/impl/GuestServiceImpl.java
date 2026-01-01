package org.docencia.hotel.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.repository.jpa.GuestJpaRepository;
import org.docencia.hotel.persistence.repository.nosql.GuestPreferencesRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz con los metodos a realizar
 */
@Service
public class GuestServiceImpl implements GuestService {
    private final GuestJpaRepository repository;
    private final GuestMapper mapper;
    private final GuestPreferencesMapper mapperPreferences;
    private final GuestPreferencesRepository repositoryPreferences;
    
    public GuestServiceImpl(GuestJpaRepository repository, GuestMapper mapper,
        GuestPreferencesRepository repositoryPreferences, GuestPreferencesMapper mapperPreferences) {
        this.repository = repository;
        this.mapper = mapper;
        this.mapperPreferences = mapperPreferences;
        this.repositoryPreferences = repositoryPreferences;
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
    @Transactional
    public Guest save(Guest guest) {
        if (guest.getId() == null ) {
            guest.setId(UUID.randomUUID().getLeastSignificantBits());
        }
        return mapper.toDomain(repository.save(mapper.toEntity(guest)));
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
    public GuestPreferences savePreferences(Long guestId, GuestPreferences preferences) {
        preferences.setGuestId(guestId);
        return mapperPreferences.toDomain(repositoryPreferences.save(mapperPreferences.toDocument(preferences)));
    }

    @Override
    @Transactional
    public boolean deletePreferenceById(Long guestId) {
        if (!repositoryPreferences.existsById(guestId)) {
            return false;
        }
        repositoryPreferences.deleteById(guestId);
        return true;
    }

    @Override
    public GuestPreferences findPreferenceById(Long guestId) {
        return mapperPreferences.toDomain(repositoryPreferences.findById(guestId).orElse(null));
    }
}
