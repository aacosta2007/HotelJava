package hotel.infraestructure.in.view.adapter;

import hotel.domain.GuestType;

import java.util.Scanner;

public class GuestTypeView {

    Scanner sc = new Scanner(System.in);

    private final GuestType guestType;

    public GuestTypeView(GuestType guestType){
        this.guestType = guestType;
    }

    public void createGuestTypeView() {
        System.out.println("Creating a new guest type...");
        System.out.println("Ingrese el id del tipo de huesped:");
        int idType = sc.nextInt();
        sc.nextLine();
        guestType.setIdType(idType);
        System.out.println("Ingrese el nombre del tipo de huesped:");
        String nameType = sc.nextLine();
        guestType.setType(nameType);
    }

}
