package hotel.domain.enums;

public enum GuestType_Enum {

    NUEVO("Nuevo"),
    FRECUENTE("Frecuente"),
    FIJO("Fijo");


    String description;

    GuestType_Enum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
