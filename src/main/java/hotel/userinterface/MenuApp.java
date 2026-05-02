package hotel.userinterface;

import hotel.infraestructure.out.db.DataBaseConnectionMySQL;
import hotel.util.FormValidationUtil;
import hotel.infraestructure.in.view.adapter.BedRoomView;
import hotel.infraestructure.in.view.adapter.EmployeeView;
import hotel.infraestructure.in.view.adapter.GuestView;

public class MenuApp {

    private final GuestView guestView;
    private final EmployeeView employeeView;
    private final BedRoomView bedRoomView;

    public MenuApp(GuestView guestView, EmployeeView employeeView, BedRoomView bedRoomView){
        this.guestView = guestView;
        this.employeeView = employeeView;
        this.bedRoomView = bedRoomView;
    }

    public void showMainMenu(){

        System.out.println("Bienvenido al Hotel Java");

        int init = FormValidationUtil.validateInt("Presione 1 para iniciar la aplicacion");
        while(init != 0){
            DataBaseConnectionMySQL.getInstance().getConnection();
            int option = FormValidationUtil.validateInt("Seleccione \n1. CRUD de usuarios \n2. CRUD de Habitaciones \n3. Salir");
            switch (option){
                case 1:
                    int in = FormValidationUtil.validateInt("¿En que tipo de CRUD deseas ingresar (1.Guest / 2.Empleado)?");
                    switch (in){
                        case 1:
                            showGuestMenu();
                            break;
                        case 2:
                            showEmployeeMenu();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Iniciar Sesion");
                    showBedRoomMenu();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }

        }
    }


    public void showGuestMenu(){
        System.out.println("Menu Huespedes");
        Boolean init = true;
        while(init){
            int option = FormValidationUtil.validateInt("Seleccione \n1. Crear Huesped \n2. Actualizar Huesped \n3. Eliminar Huesped \n4. Listar Huespedes \n5. Buscar huesped por id \n6. salir");
            switch (option){
                case 1:
                    System.out.println("Crear huesped");
                    guestView.createGuest();
                    break;
                case 2:
                    System.out.println("Actualizar Huesped");
                    guestView.updateGuest();
                    break;
                case 3:
                    System.out.println("Eliminar Huesped");
                    guestView.deleteGuest();
                    break;
                case 4:
                    System.out.println("Listar Huespedes");
                    guestView.getAllGuests();
                    break;
                case 5:
                    System.out.println("Buscar huesped por id");
                    guestView.getGuestById();
                    break;
                case 6:
                    System.out.println("Saliendo del menu de huespedes");
                    init = false;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");

            }
        }
    }


    public void showEmployeeMenu(){

        System.out.println("Menu Empleados");

        Boolean init = true;
        while(init){
            int option = FormValidationUtil.validateInt("Seleccione \n1. Crear Empleado \n2. Actualizar Empleado \n3. Eliminar Empleado \n4. Listar Empleados \n5. Buscar empleado por id \n6. salir");
            switch (option){
                case 1:
                    System.out.println("Crear empleado");
                    employeeView.createEmployee();
                    break;
                case 2:
                    System.out.println("Actualizar Empleado");
                    employeeView.updateEmployee();
                    break;
                case 3:
                    System.out.println("Eliminar Empleado");
                    employeeView.deleteEmployee();
                    break;
                case 4:
                    System.out.println("Listar Empleados");
                    employeeView.getAllEmployees();
                    break;
                case 5:
                    System.out.println("Buscar empleado por id");
                    employeeView.getEmployeeById();
                    break;
                case 6:
                    System.out.println("Saliendo del menu de empleados");
                    init = false;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");

            }
        }
    }


    public void showBedRoomMenu(){
        System.out.println("Menu Habitaciones");
        Boolean init = true;
        while(init){
            int option = FormValidationUtil.validateInt("Seleccione \n1. Crear Habitaciones \n2. Actualizar Habitaciones \n3. Eliminar Habitaciones \n4. Listar Habitaciones \n5. Buscar habitaciones por id \n6. salir");
            switch (option){
                case 1:
                    System.out.println("Crear habitacion");
                    bedRoomView.createBedRoom();
                    break;
                case 2:
                    System.out.println("Actualizar Habitaciones");
                    bedRoomView.updateBedRoom();
                    break;
                case 3:
                    System.out.println("Eliminar Habitaciones");
                    bedRoomView.deleteBedRoomById();
                    break;
                case 4:
                    System.out.println("Listar Habitaciones");
                    bedRoomView.getAllBedRooms();
                    break;
                case 5:
                    System.out.println("Buscar habitaciones por id");
                    bedRoomView.getBedRoomById();
                    break;
                case 6:
                    System.out.println("Saliendo del menu de habitaciones");
                    init = false;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");

            }
        }
    }




}
