package application.view;

import application.domain.Guest;
import application.service.GuestTypeSelector;
import application.service.outputs.GuestAdminService;
import application.service.outputs.GuestService;
import application.util.FormValidationUtil;

import java.util.List;

public class GuestView {

    private final GuestService guestService;
    private final GuestAdminService guestAdminService;

    public GuestView(GuestService guestService, GuestAdminService guestAdminService) {
        this.guestService = guestService;
        this.guestAdminService = guestAdminService;
    }

    public void createGuest() {

        System.out.println("\nCrear huesped");
        try {
            // Recolecta datos
            int id = FormValidationUtil.validateInt("Ingrese el id del Huesped");
            String name = FormValidationUtil.validateString("Ingrese el nombre del Huesped");
            String lastName = FormValidationUtil.validateString("Ingrese el apellido");
            String email = FormValidationUtil.validateString("Ingrese el email");
            String password = FormValidationUtil.validateString("Ingrese el password");
            boolean state = FormValidationUtil.validateBoolean("Estado Huesped (true/false)");
            String origin = FormValidationUtil.validateString("Ingrese el origen");
            String guestType = GuestTypeSelector.guestAddType();

            // Delega al servicio con los datos ya listos
            Guest created = guestService.createGuest(id, name, lastName, email, password, state, origin, guestType);
            System.out.println("Huesped creado: " + created.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void getAllGuests() {
        System.out.println("Mostrando todos los huespedes...");

        List<Guest> guestList = guestAdminService.getGuests();

        for (Guest guest : guestList) {
            System.out.println(guest.getId() + " "
                    + guest.getName() + " "
                    + guest.getLastName() + " "
                    + guest.getEmail() + " "
                    + guest.getGuestType() + " "
                    + guest.getState());
        }
    }

    public void getGuestById() {
        System.out.println("\nBuscar huesped por Id");
        Guest guest = guestService.getGuestById(FormValidationUtil
                .validateInt("\nIngrese el id del Huesped"))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Huesped no encontrado"
                ));

        System.out.println(guest.getId() + " "
                + guest.getName() + " "
                + guest.getLastName() + " "
                + guest.getEmail() + " "
                + guest.getGuestType() + " "
                + guest.getState());
    }

    public void updateGuest() {

        int id = FormValidationUtil.validateInt("\nIngrese el id del Huesped a Actualizar");

        int option = FormValidationUtil.validateInt("\nSeleccione campo a actualizar\n1. Nombre \n2. Apellido \n3. Email \n4. Password \n5. Estado \n6. Origen \n7. Tipo");

        Guest currentGuest = guestService.getGuestById(id).orElseThrow(() -> new IllegalArgumentException(
                "Huesped no existe"
        ));

        String name = currentGuest.getName();
        String lastName = currentGuest.getLastName();
        String email = currentGuest.getEmail();
        String password = currentGuest.getPassword();
        boolean state = currentGuest.getState();
        String origin = currentGuest.getOrigin();
        String guestType = currentGuest.getGuestType();

        System.out.println("Huesped Actual" + "\n" +
                "id: " + id + "\n" +
                "Nombre: " + name + "\n" +
                "Apellido: " + lastName + "\n" +
                "Tipo: " + guestType + "\n" +
                "Estado: " + state);

        switch (option) {
            case 1:
                name = FormValidationUtil.validateString("Ingrese el nuevo nombre");
                break;
            case 2:
                lastName = FormValidationUtil.validateString("Ingrese el nuevo apellido");
                break;
            case 3:
                email = FormValidationUtil.validateString("Ingrese el nuevo email");
                break;
            case 4:
                password = FormValidationUtil.validateString("Ingrese el nuevo password");
                break;
            case 5:
                state = FormValidationUtil.validateBoolean("Ingrese el nuevo estado (true/false)");
                break;
            case 6:
                origin = FormValidationUtil.validateString("Ingrese el nuevo origen");
                break;
            case 7:
                guestType = GuestTypeSelector.guestAddType();
                break;
            default:
                System.out.println("Seleccione una opción valida");
        }

        guestService.updateGuest(id, name, lastName, email, password, state, origin, guestType);

    }

    public void deleteGuest() {
        guestAdminService.deleteGuest(FormValidationUtil.validateInt("\nIngrese el id del Huesped a eliminar"));
    }

}
