package application.service;

import application.domain.enums.GuestType_Enum;
import application.util.FormValidationUtil;

public class GuestTypeSelector {

    public static String guestAddType(){

        System.out.println("\nSeleccione \n1. Nuevo \n2. Frecuente \n3. Fijo");
        String value = "";

        int option = FormValidationUtil.validateInt("Opción");

        switch (option){
            case 1:
                value = GuestType_Enum.NUEVO.getDescription();
                break;
            case 2:
                value = GuestType_Enum.FRECUENTE.getDescription();
                break;
            case 3:
                value = GuestType_Enum.FIJO.getDescription();
                break;
            default:
                value = "Opcion Errada";
        }

        return value;
    }

}
