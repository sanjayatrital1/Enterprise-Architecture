package edu.mum.cs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "employee")
    Set<Laptop> laptopList = new HashSet<Laptop>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addLaptop(Laptop laptop) {
        this.laptopList.add(laptop);
        laptop.setEmployee(this);
    }

    public Set<Laptop> getLaptop(){
        return laptopList;
    }
}
