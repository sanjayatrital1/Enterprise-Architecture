package edu.mum.cs.bookPublisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BookApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4association2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Publisher publisher = new Publisher();
        publisher.setName("Sanjay Trital");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Peter Cam");

        Book book =new Book();
        book.setName("EA");

        Book book2 = new Book();
        book2.setPublisher(publisher);
        book.setPublisher(publisher);

        em.persist(publisher);
        em.persist(publisher2);
        em.persist(book);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Book> bookList = em.createQuery("from Book ",Book.class).getResultList();
        for(Book b: bookList){
            System.out.println("Publisher Name: "+b.getPublisher().getName()+" Books: "+b.getName());
        }
        em.getTransaction().commit();
        em.close();

    }
}
