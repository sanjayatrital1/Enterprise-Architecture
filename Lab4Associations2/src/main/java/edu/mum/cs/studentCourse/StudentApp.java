package edu.mum.cs.studentCourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4association2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Peter");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("John");

        Course course = new Course();
        course.setName("EA");
        course.addStudent(student1);
        course.addStudent(student2);
        em.persist(course);

        em.getTransaction().commit();
        em.close();

        em= emf.createEntityManager();
        em.getTransaction().begin();

    }
}
