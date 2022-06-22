package ru.skypro;

import java.util.Locale;

public class EmployeeBook {
    private static Employee[] employees;
    private int size;   // кол-во персонала

    EmployeeBook() {
        employees = new Employee[10];
    }

    public void addEmployee(String fullName, int department, int salary) {
        if (size >= employees.length) {
            printMsgEmployeeBookIsFull();
            return;
        }
        Employee employee = new Employee(fullName, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                size++;
                break;
            }
        }
    }

    private static void printMsgEmployeeBookIsFull() {
        System.out.println("Невозможно добавить нового сотрудника. Штат полностью укомплектован");
    }

    public void removeEmployee(String fullName, int id) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().toUpperCase().equals(fullName.toUpperCase()) && employees[i].getId() == id) {
                employees[i] = null;
                size--;
                return;
            }
        }
        printNotFound();
    }

    private static void printNotFound() {
        System.out.println("Нет подходящего сотрудника");
    }

    public void removeEmployee(String fullName) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().toUpperCase().equals(fullName.toUpperCase())) {
                employees[i] = null;
                size--;
                return; // удаляем первого с таким именем
            }
        }
        printNotFound();
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                size--;
                return;
            }
        }
        printNotFound();
    }

    public void updateEmployee(String fullName, int newDepartment, int newSalary) {
        if (isDepartmentExist(newDepartment) && size > 0) {
            for (Employee emp : employees) {
                if (emp != null && emp.getFullName().toUpperCase().equals(fullName.toUpperCase())) {
                    emp.setDepartment(newDepartment);
                    emp.setSalary(newSalary);
                }
            }
        }
    }
    public void printAllEmployers() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private int getStaffSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private void printStaffSalary() {
        System.out.println("Сумма затрат на зарплату: " + getStaffSalary());
    }

    private Employee getEmployerWithMinSalary() {
        Employee employee = null;
        if (employees.length > 0) {
            employee = employees[0];
            for (Employee emp : employees) {
                if (emp != null && emp.getSalary() < employee.getSalary()) {
                    employee = emp;
                }
            }
        }
        return employee;
    }

    private void printEmployeeWithMinSalary() {
        Employee employee = getEmployerWithMinSalary();
        if (employee != null) {
            System.out.println("Минимальная зарплата у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private void printEmployeeWithMaxSalary() {
        Employee employee = getEmployeeWithMaxSalary();
        if (employee != null) {
            System.out.println("Максимальная зарплата у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private Employee getEmployeeWithMaxSalary() {
        Employee employee = null;
        if (employees.length > 0) {
            employee = employees[0];
            for (Employee emp : employees) {
                if (emp != null && emp.getSalary() > employee.getSalary()) {
                    employee = emp;
                }
            }
        }
        return employee;
    }

    private double getAverageSalary() {
        if (employees.length > 0) {
            int numberOfEmployees = 0;
            for (Employee emp : employees) {
                if (emp != null) {
                    numberOfEmployees++;
                }
            }
            return (double) getStaffSalary() / numberOfEmployees;
        } else {
            return 0.0;
        }
    }

    private void printAverageSalary() {
        System.out.println("Средняя зарплата сотрудников: " + String.format("%.2f", getAverageSalary()));
    }

    private void printStaffFullNames() {

        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null) {
                    System.out.println("Сотрудник компании: " + emp.getFullName());
                }
            }
        }
    }

    private void raiseStaffSalary(int valueInPercentage) {
        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null) {
                    emp.setSalary((int) (emp.getSalary() * (1 + valueInPercentage / 100.0)));
                }
            }
        }
    }

    private static boolean isDepartmentExist(int department) {
        return department >= 1 && department <= 5;
    }

    private static Employee getEmployeeWithMinSalary(int department) {

        Employee employee = null;
        if (employees.length > 0 && isDepartmentExist(department)) {
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    employee = emp;
                    break;
                }
            }
            if (employee != null) {
                for (Employee emp : employees) {
                    if (emp != null && emp.getDepartment() == department && emp.getSalary() < employee.getSalary()) {
                        employee = emp;
                    }
                }
            }
        }
        return employee;
    }

    private void printEmployeeWithMinSalary(int department) {
        Employee employee = getEmployeeWithMinSalary(department);
        if (employee != null) {
            System.out.println("Минимальная зарплата в отделе " + employee.getDepartment() + " у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private Employee getEmployeeWithMaxSalary(int department) {
        Employee employee = null;
        if (employees.length > 0 && isDepartmentExist(department)) {
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    employee = emp;
                    break;
                }
            }
            if (employee != null) {
                for (Employee emp : employees) {
                    if (emp != null && emp.getDepartment() == department && emp.getSalary() > employee.getSalary()) {
                        employee = emp;
                    }
                }
            }
        }
        return employee;
    }

    private void printEmployeeWithMaxSalary(int department) {
        Employee employee = getEmployeeWithMaxSalary(department);
        if (employee != null) {
            System.out.println("Максимальная зарплата в отделе " + employee.getDepartment() +
                    " у сотрудника: " + employee.getFullName() + ". Зарплата: " + employee.getSalary() +
                    ". Идентификационный номер: " + employee.getId());
        }
    }

    private int getStaffSalary(int department) {
        int sum = 0;
        if (isDepartmentExist(department)) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
        }
        return sum;
    }

    private void printStaffSalary(int department) {
        System.out.println("Сумма затрат на зарплату в отделе: " + department + " составляет " + getStaffSalary(department));
    }

    private double getAverageSalary(int department) {
        if (employees.length > 0 && isDepartmentExist(department)) {
            int numberOfEmployees = 0;
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    numberOfEmployees++;
                }
            }
            if (numberOfEmployees != 0) {
                return (double) getStaffSalary(department) / numberOfEmployees;
            } else {
                return 0.0;
            }
        } else {
            return 0.0;
        }
    }

    private void printAverageSalary(int department) {
        System.out.println("Средняя зарплата сотрудников в отделе " + department +
                " составляет " + String.format("%.2f", getAverageSalary(department)));
    }

    private void raiseStaffSalary(int department, int valueInPercentage) {
        if (employees.length > 0 && isDepartmentExist(department)) {
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    emp.setSalary((int) (emp.getSalary() * (1 + valueInPercentage / 100.0)));
                }
            }
        }
    }

    private void printStaffFullNames(int department) {

        if (employees.length > 0 && isDepartmentExist(department)) {
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    System.out.println("Сотрудник отдела: " + emp.getFullName() +
                            ". id: " + emp.getId() + ". Зарплата: " + emp.getSalary());
                }
            }
        }
    }

    private Employee[] getEmployeesWhichSalaryLessThanValue(int salaryValue) {
        Employee[] employeesArr;
        int count = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() < salaryValue) {
                count++;
            }
        }
        employeesArr = new Employee[count];
        count = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() < salaryValue) {
                employeesArr[count++] = emp;
            }
        }
        return employeesArr;
    }

    private void printEmployeesWhichSalaryLessThanValue(int salaryValue) {
        Employee[] employeesArr = getEmployeesWhichSalaryLessThanValue(salaryValue);

        for (Employee emp : employeesArr) {
            if (emp != null) {
                System.out.println("id: " + emp.getId() + " ФИО: " + emp.getFullName() + " Зарплата: " + emp.getSalary());
            }
        }
    }

    private Employee[] getEmployeesWhichSalaryMoreThanValue(int salaryValue) {
        Employee[] employeesArr;
        int count = 0;

        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() >= salaryValue) {
                count++;
            }
        }
        employeesArr = new Employee[count];
        count = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() >= salaryValue) {
                employeesArr[count++] = emp;
            }
        }
        return employeesArr;
    }

    private void printEmployeesWhichSalaryMoreThanValue(int salaryValue) {
        Employee[] employeesArr = getEmployeesWhichSalaryMoreThanValue(salaryValue);

        for (Employee emp : employeesArr) {
            if (emp != null) {
                System.out.println("id: " + emp.getId() + " ФИО: " + emp.getFullName() + " Зарплата: " + emp.getSalary());
            }
        }
    }
}
