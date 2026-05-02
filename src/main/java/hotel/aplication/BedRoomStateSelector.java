package hotel.aplication;

import hotel.domain.enums.BedRoomState;
import hotel.util.FormValidationUtil;

public class BedRoomStateSelector {

    public static String bedRoomAddState(){

        System.out.println("\nSeleccione \n1. Disponible \n2. Ocupada \n3. En Mantenimiento \n4. Reservada ");
        String value = "";

        int option = FormValidationUtil.validateInt("Opción");

        switch (option){
            case 1:
                value = BedRoomState.DISPONIBLE.getDescription();
                break;
            case 2:
                value = BedRoomState.OCUPADA.getDescription();
                break;
            case 3:
                value = BedRoomState.MANTENIMIENTO.getDescription();
                break;
            case 4:
                value = BedRoomState.RESERVADA.getDescription();
            default:
                value = "Opcion Errada";

        }

        return value;
    }

}
