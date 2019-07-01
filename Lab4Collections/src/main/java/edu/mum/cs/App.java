package edu.mum.cs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String [] args){
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setName("Sanjay");

        Laptop laptop = new Laptop();
        laptop.setModel("Dell5255");

        employee.addLaptop(laptop);

        em.persist(laptop);

        em.persist(employee);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> empQuery = em.createQuery("from Employee ", Employee.class);
        List<Employee> employeeList = empQuery.getResultList();
        for(Employee e: employeeList){
            System.out.println("Name= "+e.getName()+", Laptop Model= "+e.getLaptop().toString());
        }

    em.getTransaction().commit();
        em.close();


    }
}
