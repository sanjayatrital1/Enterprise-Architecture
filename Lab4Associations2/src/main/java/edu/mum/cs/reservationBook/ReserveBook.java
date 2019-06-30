package edu.mum.cs.reservationBook;

import edu.mum.cs.bookPublisher.Book;
import edu.mum.cs.customerReservation.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReserveBook {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4association2");
        EntityManager em = emf.createEntityManager();

        Book book = new Book();
        book.setName("WAA");
        Reservation reservation =new Reservation();
        reservation.setName("CS book");
        reservation.setBook(book);

        em.getTransaction().begin();
        em.persist(book);
        em.persist(reservation);
        em.getTransaction().commit();
        em. close();
    }
}
