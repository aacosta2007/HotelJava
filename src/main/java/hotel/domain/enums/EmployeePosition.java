package hotel.domain.enums;

public enum EmployeePosition {

    RECEPCIONISTA("Recepcionista"),
    ADMINISTRADOR("Administrador"),
    LIMPIEZA("Limpieza"),
    SEGURIDAD("Seguridad");


    String description;

    EmployeePosition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
