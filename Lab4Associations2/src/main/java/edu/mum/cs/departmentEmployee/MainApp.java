package edu.mum.cs.departmentEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        List<Employee>emplist = new ArrayList<Employee>();
        emf = Persistence.createEntityManagerFactory("lab4association2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setName("Sanajay Trital");
        Employee emp2 = new Employee();
        emp2.setName("John");

        Department department = new Department();
        department.setName("Software Engineer");
        department.addEmployee(employee);

        Department department2 = new Department();
        department2.setName("Network Engineer");
        department2.addEmployee(emp2);

        em.persist(department);
        em.persist(department2);

        em.persist(employee);
        em.persist(emp2);


        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Department> result = em.createQuery("from Department ", Department.class).getResultList();
        for(Department d: result){
            System.out.println("Department Name: "+d.getName());
                System.out.println(" Employee Name: "+d.getEmployeeList().toString());

        }
        em.getTransaction().commit();
        em.close();
    }
}
