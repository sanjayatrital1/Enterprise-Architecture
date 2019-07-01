package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("Duplicates")
public class App {

    public static EntityManagerFactory emf;

    public static void main(String [] args){
        emf = Persistence.createEntityManagerFactory("simpsons");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Students> displayStudents = em.createQuery("from edu.mum.cs544.Students ",Students.class);
        List<Students> studentList = displayStudents.getResultList();
        for(Students stu: studentList){
            System.out.println("Name: "+stu.getName());
        }
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        Students s = new Students();
        s.setId(1010);
        s.setName("Sanjay");
        s.setEmail("strital@mum.edu");
        s.setPassword("1234");

        if(!studentList.contains(s)){
            em.persist(s);
        }

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> studentsTypedQuery = em.createQuery("from edu.mum.cs544.Students ", Students.class);
        List<Students> stuList = studentsTypedQuery.getResultList();
        for(Students st : stuList){
            System.out.println("Name: "+st.getName());
        }
        em.getTransaction().commit();
        em.close();

    }
}
