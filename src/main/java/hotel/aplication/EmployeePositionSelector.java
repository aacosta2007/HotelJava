package hotel.aplication;

import hotel.domain.enums.EmployeePosition;
import hotel.util.FormValidationUtil;

public class EmployeePositionSelector {

    public static String employeeAddPosition(){

        System.out.println("\nSeleccione \n1. Recepcionista \n2. Administrador \n3. Limpieza \n4. Seguridad");
        String value = "";

        int option = FormValidationUtil.validateInt("Opción");

        switch (option){
            case 1:
                value = EmployeePosition.RECEPCIONISTA.getDescription();
                break;
            case 2:
                value = EmployeePosition.ADMINISTRADOR.getDescription();
                break;
            case 3:
                value = EmployeePosition.LIMPIEZA.getDescription();
                break;
            case 4:
                value = EmployeePosition.SEGURIDAD.getDescription();
                break;
            default:
                value = "Opcion Errada";
        }

        return value;
    }

}
