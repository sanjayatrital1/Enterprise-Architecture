package edu.mum.cs;

import javax.persistence.*;

//@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private long id;
    private String model;
    @ManyToOne
    private Employee employee;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Model  "+getModel() ;
    }
}
