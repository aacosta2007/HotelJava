package hotel.infraestructure.in.view.adapter;

import hotel.domain.Employee;
import hotel.aplication.EmployeePositionSelector;
import hotel.aplication.inputs.EmployeeService;
import hotel.util.FormValidationUtil;

import java.util.List;

public class EmployeeView {

    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void createEmployee() {

        System.out.println("\nCrear empleado");
        try {
            // Recolecta datos
            int id = FormValidationUtil.validateInt("Ingrese el id del Empleado");
            String name = FormValidationUtil.validateString("Ingrese el nombre del Empleado");
            String lastName = FormValidationUtil.validateString("Ingrese el apellido");
            String email = FormValidationUtil.validateString("Ingrese el email");
            String password = FormValidationUtil.validateString("Ingrese el password");
            boolean state = FormValidationUtil.validateBoolean("Estado Empleado (true/false)");
            String position = EmployeePositionSelector.employeeAddPosition();
            double salary = FormValidationUtil.validateDouble("Ingrese el salario");

            // Delega al servicio con los datos ya listos
            Employee created = employeeService.createEmployee(id, name, lastName, email, password, state, position, salary);
            System.out.println("Empleado creado: " + created.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void getAllEmployees() {
        System.out.println("Mostrando todos los empleados...");

        List<Employee> employeeList = employeeService.getAllEmployees();

        for (Employee employee : employeeList) {
            System.out.println(employee.getId() + " "
                    + employee.getName() + " "
                    + employee.getLastName() + " "
                    + employee.getEmail() + " "
                    + employee.getPosition() + " "
                    + employee.getSalary() + " "
                    + employee.getState());
        }
    }

    public void getEmployeeById() {
        System.out.println("\nBuscar empleado por Id");
        Employee employee = employeeService.getEmployeeById(FormValidationUtil
                .validateInt("Ingrese el id del Empleado"))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Empleado no encontrado"
                ));

        System.out.println(employee.getId() + " "
                + employee.getName() + " "
                + employee.getLastName() + " "
                + employee.getEmail() + " "
                + employee.getPosition() + " "
                + employee.getSalary() + " "
                + employee.getState());
    }

    public void updateEmployee() {

        int id = FormValidationUtil.validateInt("\nIngrese el id del Empleado a Actualizar");

        int option = FormValidationUtil.validateInt("\nSeleccione campo a actualizar\n1. Nombre \n2. Apellido \n3. Email \n4. Password\n 5. Estado \n6. Cargo \n7. Salario");

        Employee currentEmployee = employeeService.getEmployeeById(id).orElseThrow(() -> new IllegalArgumentException(
                "Empleado no existe"
        ));

        String name = currentEmployee.getName();
        String lastName = currentEmployee.getLastName();
        String email = currentEmployee.getEmail();
        String password = currentEmployee.getPassword();
        boolean state = currentEmployee.getState();
        String position = currentEmployee.getPosition();
        double salary = currentEmployee.getSalary();

        System.out.println("Empleado Actual" + "\n" +
                "id: " + id + "\n" +
                "Nombre: " + name + "\n" +
                "Apellido: " + lastName + "\n" +
                "Cargo: " + position + "\n" +
                "Salario: " + salary + "\n" +
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
                position = EmployeePositionSelector.employeeAddPosition();
                break;
            case 7:
                salary = FormValidationUtil.validateDouble("Ingrese el nuevo salario");
                break;
            default:
                System.out.println("Seleccione una opción valida");
        }

        employeeService.updateEmployee(id, name, lastName, email, password, state, position, salary);

    }

    public void deleteEmployee() {
        employeeService.deleteEmployeeById(FormValidationUtil.validateInt("\nIngrese el id del Empleado a eliminar"));
    }

}
