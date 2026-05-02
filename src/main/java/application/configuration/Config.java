package application.configuration;

import application.repository.BedRoomRepository;
import application.repository.BedRoomTypeRepository;
import application.repository.EmployeeRepository;
import application.repository.GuestRepository;
import application.service.BedRoomServiceImp;
import application.service.EmployeeServiceImpl;
import application.service.GuestAdminServiceImpl;
import application.service.GuestServiceImpl;
import application.service.outputs.BedRoomService;
import application.service.outputs.EmployeeService;
import application.service.outputs.GuestAdminService;
import application.service.outputs.GuestService;
import application.service.ports.BedRoomRepositoryPort;
import application.service.ports.EmployeeRepositoryPort;
import application.service.ports.GuestRepositoryPort;
import application.userinterface.MenuApp;
import application.view.BedRoomView;
import application.view.EmployeeView;
import application.view.GuestView;

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
