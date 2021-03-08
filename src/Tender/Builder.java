package Tender;

import java.util.EnumSet;

public class Builder {
    private EnumSet<Specialty> specialties;
    private int salary;

    public EnumSet<Specialty> getSpecialties() {
        return specialties;
    }

    public int getSalary() {
        return salary;
    }

    public Builder(EnumSet<Specialty> specialties, int salary) {
        this.specialties = specialties;
        this.salary = salary;
    }
}
