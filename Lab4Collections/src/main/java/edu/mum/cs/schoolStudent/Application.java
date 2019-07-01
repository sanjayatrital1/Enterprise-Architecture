package edu.mum.cs.schoolStudent;

import com.google.protobuf.MapEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

public class Application {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student();
        student.setName("Sanjay");

        School school = new School();
        school.setName("MUM");
        school.addStudent(student);
        em.persist(school);
        em.persist(student);

        em.getTransaction().commit();
        em.close();

        List<School>schoolList = em.createQuery("from School ", School.class).getResultList();
        for(School s: schoolList){
            System.out.println("School Name = "+s.getName());
            for(Map.Entry<Integer,Student> mapEntry:s.getStudentMap().entrySet()) {
                System.out.println("Student Name= "+mapEntry.getValue().getName());
            }
        }

        em.getTransaction().commit();
        em.close();

    }
}
