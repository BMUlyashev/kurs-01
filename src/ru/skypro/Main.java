package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иванов Иван Иванович", 1, 15000);
        employeeBook.addEmployee("Иванов Алексей Иванович", 2, 35000);
        employeeBook.addEmployee("Сергеев Иван Иванович", 3, 25000);
        employeeBook.addEmployee("Сергеев Иван Иванович", 3, 25000);
        employeeBook.addEmployee("Пучков Иван Иванович", 3, 45000);
        employeeBook.addEmployee("Клязин Иван Иванович", 3, 15000);
        employeeBook.addEmployee("Петров Иван Иванович", 3, 35000);
        employeeBook.printAllEmployers();
        employeeBook.updateEmployee("сергеев иван иванович", 4, 36000);
        employeeBook.printAllEmployers();
        employeeBook.printEmployeeWithMinSalary();
        employeeBook.printStaffFullNames(4);
        employeeBook.printStaffFullNames(0);

        employeeBook.printEmployeesByDepartments();

    }


}
