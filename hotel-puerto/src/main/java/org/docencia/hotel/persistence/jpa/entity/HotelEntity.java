package org.docencia.hotel.persistence.jpa.entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "hotel")
    private Set<RoomEntity> rooms;

    /**
     * Constructor vacio de la clase HotelEntity
     */
    public HotelEntity() {
    }

    /**
     * Constructor con el identificador de la clase HotelEntity
     * @param id iendtificador del hotel
     */
    public HotelEntity(Long id) {
        this.id = id;
    }

    /**
     * Constructor con los atributos de la clase HotelEntity
     * @param id identificador del hotel
     * @param name nombre del hotel
     * @param address direccion del hotel
     * @param rooms habitaciones del hotel
     */
    public HotelEntity(Long id, String name, String address, Set<RoomEntity> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<RoomEntity> getRooms() {
        return this.rooms;
    }

    public void setRooms(Set<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HotelEntity)) {
            return false;
        }
        HotelEntity hotelEntity = (HotelEntity) o;
        return Objects.equals(id, hotelEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", rooms='" + getRooms() + "'" +
            "}";
    }
    
}
