package ru.skypro;

public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
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

        printAllEmployers();
        printStaffSalary();
        printEmployeeWithMinSalary();
        printEmployeeWithMaxSalary();
        printAverageSalary();
        printStaffFullNames();

        raiseStaffSalary(10);
        printAllEmployers();

        printEmployeeWithMinSalary(1);
        printSeparator();
        printEmployeeWithMaxSalary(4);
        printSeparator();
        printStaffSalary(3);
        printSeparator();
        printAverageSalary(2);
        printSeparator();
        raiseStaffSalary(3, 5);
        printSeparator();
        printStaffSalary(3);
        printSeparator();
        printStaffFullNames(3);
        printSeparator();
        printEmployeesWhichSalaryLessThanValue(90000);
        printSeparator();
        printEmployeesWhichSalaryMoreThanValue(90000);
    }

    private static void printSeparator() {
        System.out.println("*********************************************************************");
    }
    private static void printAllEmployers() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static int getStaffSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static void printStaffSalary() {
        System.out.println("Сумма затрат на зарплату: " + getStaffSalary());
    }

    private static Employee getEmployerWithMinSalary() {
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

    private static void printEmployeeWithMinSalary() {
        Employee employee = getEmployerWithMinSalary();
        if (employee != null) {
            System.out.println("Минимальная зарплата у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private static void printEmployeeWithMaxSalary() {
        Employee employee = getEmployeeWithMaxSalary();
        if (employee != null) {
            System.out.println("Максимальная зарплата у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private static Employee getEmployeeWithMaxSalary() {
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

    private static double getAverageSalary() {
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

    private static void printAverageSalary() {
        System.out.println("Средняя зарплата сотрудников: " + String.format("%.2f", getAverageSalary()));
    }

    private static void printStaffFullNames() {

        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null) {
                    System.out.println("Сотрудник компании: " + emp.getFullName());
                }
            }
        }
    }

    private static void raiseStaffSalary(int valueInPercentage) {
        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null) {
                    emp.setSalary((int) (emp.getSalary() * (1 + valueInPercentage / 100.0)));
                }
            }
        }
    }

    private static Employee getEmployeeWithMinSalary(int department) {
        Employee employee = null;
        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp.getDepartment() == department) {
                    employee = emp;
                    break;
                }
            }
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department && emp.getSalary() < employee.getSalary()) {
                    employee = emp;
                }
            }
        }
        return employee;
    }

    private static void printEmployeeWithMinSalary(int department) {
        Employee employee = getEmployeeWithMinSalary(department);
        if (employee != null) {
            System.out.println("Минимальная зарплата в отделе " + employee.getDepartment() + " у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private static Employee getEmployeeWithMaxSalary(int department) {
        Employee employee = null;
        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp.getDepartment() == department) {
                    employee = emp;
                    break;
                }
            }
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department && emp.getSalary() > employee.getSalary()) {
                    employee = emp;
                }
            }
        }
        return employee;
    }

    private static void printEmployeeWithMaxSalary(int department) {
        Employee employee = getEmployeeWithMaxSalary(department);
        if (employee != null) {
            System.out.println("Максимальная зарплата в отделе " + employee.getDepartment() + " у сотрудника: " + employee.getFullName() +
                    ". Зарплата: " + employee.getSalary() + ". Идентификационный номер: " + employee.getId());
        }
    }

    private static int getStaffSalary(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static void printStaffSalary(int department) {
        System.out.println("Сумма затрат на зарплату в отделе: " + department + " составляет " + getStaffSalary(department));
    }

    private static double getAverageSalary(int department) {
        if (employees.length > 0) {
            int numberOfEmployees = 0;
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    numberOfEmployees++;
                }
            }
            return (double) getStaffSalary(department) / numberOfEmployees;
        } else {
            return 0.0;
        }
    }

    private static void printAverageSalary(int department) {
        System.out.println("Средняя зарплата сотрудников в отделе " + department +
                " составляет " + String.format("%.2f", getAverageSalary(department)));
    }

    private static void raiseStaffSalary(int department, int valueInPercentage) {
        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    emp.setSalary((int) (emp.getSalary() * (1 + valueInPercentage / 100.0)));
                }
            }
        }
    }

    private static void printStaffFullNames(int department) {

        if (employees.length > 0) {
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == department) {
                    System.out.println("Сотрудник отдела: " + emp.getFullName() +
                            ". id: " + emp.getId() + ". Зарплата: " + emp.getSalary());
                }
            }
        }
    }

    private static Employee[] getEmployeesWhichSalaryLessThanValue(int salaryValue) {
        Employee[] employeesArr = new Employee[employees.length];
        int i = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() < salaryValue) {
                employeesArr[i++] = emp;
            }
        }
        return employeesArr;
    }

    private static void printEmployeesWhichSalaryLessThanValue(int salaryValue) {
        Employee[] employeesArr = getEmployeesWhichSalaryLessThanValue(salaryValue);

        for (Employee emp : employeesArr) {
            if (emp != null) {
                System.out.println("id: " + emp.getId() + " ФИО: " + emp.getFullName() + " Зарплата: " + emp.getSalary());
            }
        }
    }

    private static Employee[] getEmployeesWhichSalaryMoreThanValue(int salaryValue) {
        Employee[] employeesArr = new Employee[employees.length];
        int i = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() >= salaryValue) {
                employeesArr[i++] = emp;
            }
        }
        return employeesArr;
    }

    private static void printEmployeesWhichSalaryMoreThanValue(int salaryValue) {
        Employee[] employeesArr = getEmployeesWhichSalaryMoreThanValue(salaryValue);

        for (Employee emp : employeesArr) {
            if (emp != null) {
                System.out.println("id: " + emp.getId() + " ФИО: " + emp.getFullName() + " Зарплата: " + emp.getSalary());
            }
        }
    }
}
