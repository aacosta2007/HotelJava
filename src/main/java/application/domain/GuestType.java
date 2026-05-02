package application.domain;

public class GuestType {

    private int idType;
    private String type;

    public GuestType(int idType, String type) {
        this.idType = idType;
        this.type = type;
    }

    public GuestType() {
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GuestType{" +
                "idType=" + idType +
                ", type='" + type + '\'' +
                '}';
    }
}
