package org.docencia.hotel.domain.model;

import java.util.List;
import java.util.Objects;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class GuestPreferences {
    private Long guestId;

    private String preferredLanguage;

    private boolean newsLetterOptIn;

    private List<String> tags;

    private String favoriteRoomType;

    private String notes;

    /**
     * Constructor vacio de la clase GuestPreferences
     */
    public GuestPreferences() {
    }

    /**
     * Constructor con el identificardor de la clase GuestPreferences y del del guest
     *
     * @param guestId identificador del guest
     */
    public GuestPreferences(Long guestId) {
        this.guestId = guestId;
    }

    /**
     * Constructor con todos los atributos de la clase GuestPreferences
     *
     * @param guestId identificador de la clase Guest
     * @param preferredLanguage leguaje de preferecia del guestEntity
     * @param newsLetterOptIn si tiene preferencia a recibir el preiodico
     * @param tags etiquetas del guest
     * @param favoriteRoomType tipo de habitacion favorita del guest
     * @param notes notas del guest
     */
    public GuestPreferences(Long guestId, String preferredLanguage, boolean newsLetterOptIn, List<String> tags, String favoriteRoomType, String notes) {
        this.guestId = guestId;
        this.preferredLanguage = preferredLanguage;
        this.newsLetterOptIn = newsLetterOptIn;
        this.tags = tags;
        this.favoriteRoomType = favoriteRoomType;
        this.notes = notes;
    }

    public Long getGuestId() {
        return this.guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public boolean getNewsLetterOptIn() {
        return newsLetterOptIn;
    }

    public void setNewsLetterOptIn(boolean newsLetterOptIn) {
        this.newsLetterOptIn = newsLetterOptIn;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getFavoriteRoomType() {
        return this.favoriteRoomType;
    }

    public void setFavoriteRoomType(String favoriteRoomType) {
        this.favoriteRoomType = favoriteRoomType;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GuestPreferences)) {
            return false;
        }
        GuestPreferences guestPreferences = (GuestPreferences) o;
        return Objects.equals(guestId, guestPreferences.guestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId);
    }

    @Override
    public String toString() {
        return "{" +
            " guestId='" + getGuestId() + "'" +
            ", preferredLanguage='" + getPreferredLanguage() + "'" +
            ", newsLetterOptIn='" + getNewsLetterOptIn() + "'" +
            ", tags='" + getTags() + "'" +
            ", favoriteRoomType='" + getFavoriteRoomType() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
    
}
