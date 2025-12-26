package org.docencia.hotel.persistence.nosql.document;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
//TODO: verificar el equals si se hace con el id de la clase o de GuestEntity y el constructor con el id tambien
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Document(collection = "guest_preferences")
public class GuestPreferencesDocument {

    @Id
    private String id;

    @Field("guestId")
    private Long guestId;

    @Field("preferredLanguage")
    private String preferredLanguage;

    @Field("newsLetterOptIn")
    private boolean newsLetterOptIn;

    @Field("tags")
    private List<String> tags;

    @Field("favoriteRoomType")
    private String favoriteRoomType;

    @Field("notes")
    private String notes;

    /**
     * Constructor vacio
     */
    public GuestPreferencesDocument() {
    }

    /**
     * Constructor con todos los atributos de la clase
     *
     * @param id identificador de la clase GuestReference
     * @param guestId id del guest
     * @param preferredLanguage leguaje de preferecia del guest
     * @param newsLetterOptIn si tiene preferencia a recibir el preiodico
     * @param tags etiquetas del guest
     * @param favoriteRoomType tipo de habitacion favorita del guest
     * @param notes notas del guest
     */
    public GuestPreferencesDocument(String id, Long guestId, String preferredLanguage,
            boolean newsLetterOptIn, List<String> tags, String favoriteRoomType, String notes) {
        this.id = id;
        this.guestId = guestId;
        this.preferredLanguage = preferredLanguage;
        this.newsLetterOptIn = newsLetterOptIn;
        this.tags = tags;
        this.favoriteRoomType = favoriteRoomType;
        this.notes = notes;
    }

    /**
     * Constructor con el identificardor para relacionar la clase
     * GuestPreferencesDocument con la clase GuestEntity
     *
     * @param guestId identificador del guest
     */
    public GuestPreferencesDocument(Long guestId) {
        this.guestId = guestId;
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

    public boolean isNewsletterOptIn() {
        return this.newsLetterOptIn;
    }

    public boolean getNewsletterOptIn() {
        return this.newsLetterOptIn;
    }

    public void setNewsletterOptIn(boolean newsLetterOptIn) {
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
        if (o == this) {
            return true;
        }
        if (!(o instanceof GuestPreferencesDocument)) {
            return false;
        }
        GuestPreferencesDocument guestPreferences = (GuestPreferencesDocument) o;
        return Objects.equals(guestId, guestPreferences.guestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId);
    }

    @Override
    public String toString() {
        return "{"
                + " guestId='" + getGuestId() + "'"
                + ", preferredLanguage='" + getPreferredLanguage() + "'"
                + ", newsletterOptIn='" + isNewsletterOptIn() + "'"
                + ", tags='" + getTags() + "'"
                + ", favoriteRoomType='" + getFavoriteRoomType() + "'"
                + ", notes='" + getNotes() + "'"
                + "}";
    }
}
