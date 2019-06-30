package edu.mum.cs.employeeOffice;

import edu.mum.cs.departmentEmployee.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OfficeApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4association2");
        EntityManager em = emf.createEntityManager();
        Office office = new Office();
        office.setName("MUM");

        Employee employee = new Employee();
        employee.setName("Sanjay Trital");
        employee.setOffice(office);

        Employee employee2 = new Employee();
        employee2.setName("Michal");
        employee2.setOffice(office);

        em.getTransaction().begin();
        em.persist(office);
        em.persist(employee);
        em.persist(employee2);
        em.getTransaction().commit();
        em.close();
    }
}
