package application.domain;

import java.util.Scanner;

public class Services {
    Scanner in = new Scanner(System.in);
    private int id;
    private String name;
    private double price;
    private  boolean state;

    public Services(){
    }

    public Services(Scanner in, int idService, String nameService, double price, boolean state) {
        this.in = in;
        this.id = idService;
        this.name = nameService;
        this.price = price;
        this.state = state;
    }

    // GET AND SETTER

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public int getIdService() {
        return id;
    }

    public void setIdService(int idService) {
        this.id = idService;
    }

    public String getNameService() {
        return name;
    }

    public void setNameService(String nameService) {
        this.name = nameService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    // METODOS
    public Services createService(Services services){
        System.out.print("Ingrese el id del servicio: ");
        int id = in.nextInt();
        services.id = id;
        in.nextLine();
        System.out.print("ingrese el nombre del servicio: ");
        String name = in.nextLine();
        services.name = name;
        System.out.println("Ingrese el nombre del precio: ");
        double price = in.nextDouble();
        services.price = price;
        in.nextLine();
        System.out.println("Ingrese el estado del servicio: ");
        boolean state = in.nextBoolean();
        services.state = state;
        return services;
    }
    public Services updateServices(int id, Services services){
        if (this.id==id){
            System.out.print("Ingrese el nuevo nombre: ");
            String newName = in.nextLine();
            services.name = newName;
            System.out.println("Ingrese el nuevo precio:");
            double newPrice = in.nextDouble();
            services.price = newPrice;
            in.nextLine();
            System.out.println("Ingrese el nuevo estado: ");
            boolean newState = in.nextBoolean();
            services.state = newState;
        }else{
            System.out.print("Validar el id ingresado");
        }
        return services;
    }

    public Services getServicesById(int id, Services services){
        if (this.id==id){
            System.out.println("Servicios\n"+
                    "Id: "+services.id+"\n"+
                    "Nombre: "+services.name+"\n"+
                    "Precio: "+services.price+"\n"+
                    "Estado: "+services.state+"\n");
        }else{
            System.out.println("Validar el id ingresado");
        }
        return  null;
    }
    public void deleteServices (int id, Services services){
        if (this.id==id){
            services.state=false;
            System.out.println("El Servicio con id: "+id+" ha sido elimanado");
        }else{
            System.out.println("Validar el id ingresado");
        }
    }
}
