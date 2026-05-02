package hotel.configuration;

import hotel.infraestructure.out.adapter.BedRoomRepository;
import hotel.infraestructure.out.adapter.BedRoomTypeRepository;
import hotel.infraestructure.out.adapter.EmployeeRepository;
import hotel.infraestructure.out.adapter.GuestRepository;
import hotel.aplication.BedRoomServiceImp;
import hotel.aplication.EmployeeServiceImpl;
import hotel.aplication.GuestAdminServiceImpl;
import hotel.aplication.GuestServiceImpl;
import hotel.aplication.inputs.BedRoomService;
import hotel.aplication.inputs.EmployeeService;
import hotel.aplication.inputs.GuestAdminService;
import hotel.aplication.inputs.GuestService;
import hotel.aplication.ports.BedRoomRepositoryPort;
import hotel.aplication.ports.EmployeeRepositoryPort;
import hotel.aplication.ports.GuestRepositoryPort;
import hotel.userinterface.MenuApp;
import hotel.infraestructure.in.view.adapter.BedRoomView;
import hotel.infraestructure.in.view.adapter.EmployeeView;
import hotel.infraestructure.in.view.adapter.GuestView;

public class Config {

    public static MenuApp createMenuApp(){

        GuestRepositoryPort guestRepositoryPort = new GuestRepository();
        GuestService guestService = new GuestServiceImpl(guestRepositoryPort);
        GuestAdminService guestAdminService = new GuestAdminServiceImpl(guestRepositoryPort);
        GuestView guestView = new GuestView(guestService, guestAdminService);

        EmployeeRepositoryPort employeeRepositoryPort = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepositoryPort);
        EmployeeView employeeView = new EmployeeView(employeeService);

        BedRoomTypeRepository bedRoomTypeRepository = new BedRoomTypeRepository();

        BedRoomRepositoryPort bedRoomRepositoryPort = new BedRoomRepository();
        BedRoomService bedRoomService = new BedRoomServiceImp(bedRoomRepositoryPort, bedRoomTypeRepository);
        BedRoomView bedRoomView = new BedRoomView(bedRoomService);

        return new MenuApp(guestView, employeeView, bedRoomView);
    }




}
