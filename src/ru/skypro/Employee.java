package ru.skypro;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private int salary;
    private final int id;
    private static int counter;

    Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        setDepartment(department);
        setSalary(salary);
        this.id = counter++;
    }

    public String getFullName() {return fullName;}
    public int getDepartment() {return department;}
    public int getSalary() {return salary;}
    public int getId() {return id;}
    public int getCounter() {return counter;}

    public static boolean isDepartmentExist(int department) {
        return department >= 1 && department <= 5;
    }

    public void setDepartment(int department) {
        if (!isDepartmentExist(department)) {
            throw new IllegalArgumentException("Отдел сотрудника должен быть от 1 до 5.");
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата сотрудника не может быть меньше 0.");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ФИО сотрудника: " + fullName + " Зарплата сотрудника: " + salary +
                " Номер отдела: " + department + " Идентификационный номер: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
