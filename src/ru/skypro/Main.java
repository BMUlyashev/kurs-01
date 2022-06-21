package ru.skypro;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Сергеев Иван Семенович", 1, 8500);
        employees[1] = new Employee("Иванов Виктор Иванович", 2, 65000);
        employees[2] = new Employee("Чайка Егор Алексеевич", 3, 45000);
        employees[3] = new Employee("Матвеюк Иван Григорьевич", 3, 95000);
        employees[4] = new Employee("Рыбаков Сергей Борисович", 5, 100000);
        employees[5] = new Employee("Лесин Юрий Викторович", 4, 90000);
        employees[6] = new Employee("Верник Владимир Иванович", 4, 80000);
        employees[7] = new Employee("Круглова Анастасия Ивановна", 2, 73000);
        employees[8] = new Employee("Иванова Юлия Владимировна", 1, 96000);
        employees[9] = new Employee("Сергеев Борис Иванович", 5, 98000);

        printAllEmployers(employees);
        printStaffSalary(employees);
        printEmployerWithMinSalary(employees);
        printEmployerWithMaxSalary(employees);
        printAverageSalary(employees);
        printStaffFullNames(employees);
    }

    private static void printAllEmployers(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static int getStaffSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static void printStaffSalary(Employee[] employees) {
        System.out.println("Сумма затрат на зарплату: " + getStaffSalary(employees));
    }

    private static Employee getEmployerWithMinSalary(Employee[] employees) {
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

    private static void printEmployerWithMinSalary(Employee[] employees) {
        Employee employee = getEmployerWithMinSalary(employees);
        System.out.println("Минимальная зарплата у сотрудника: " + employee.getFullName() +
                ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
    }

    private static void printEmployerWithMaxSalary(Employee[] employees) {
        Employee employee = getEmployerWithMaxSalary(employees);
        System.out.println("Максимальная зарплата у сотрудника: " + employee.getFullName() +
                ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
    }

    private static Employee getEmployerWithMaxSalary(Employee[] employees) {
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

    private static double getAverageSalary(Employee[] employees) {
        if (employees.length > 0) {
            int numberOfEmployees = 0;
            for (Employee emp : employees) {
                if (emp != null) {
                    numberOfEmployees++;
                }
            }
            return (double) getStaffSalary(employees) / numberOfEmployees;
        } else {
            return 0.0;
        }
    }

    private static void printAverageSalary(Employee[] employees) {
        System.out.println("Средняя зарплата сотрудников: " + String.format("%.2f", getAverageSalary(employees)));
    }

    private static void printStaffFullNames(Employee[] employees) {

        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null) {
                    System.out.println("Сотрудник компании: " + emp.getFullName());
                }
            }
        }
    }
}
