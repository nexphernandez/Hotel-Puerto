package org.docencia.hotel.service.api;

import java.util.Set;

import org.docencia.hotel.domain.model.Guest;
/**
 * @author nexphernandez
 * @version 1.0.0
 * Interfaz con los metodos a realizar
 */
public interface GuestService {
     /**
     * Comprueba si existe un huésped con el ID especificado.
     * @param id ID del huésped a buscar
     * @return true si el huésped existe, false en caso contrario
     */
    boolean existsById(Long id);

    /**
     * Busca y devuelve un huésped por su ID.
     * @param id ID del huésped a buscar
     * @return el huésped si existe, null en caso contrario
     */
    Guest findById(Long id);

    /**
     * Devuelve un conjunto con todos los huéspedes registrados.
     * @return conjunto de todos los huéspedes
     */
    Set<Guest> findAll();

    /**
     * Guarda un huésped nuevo o actualiza uno existente.
     * @param guest huésped a guardar o actualizar
     * @return el huésped guardado o actualizado
     */
    Guest save(Guest guest);

    /**
     * Elimina un huésped por su ID.
     * @param id ID del huésped a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    boolean deleteById(Long id);
}
