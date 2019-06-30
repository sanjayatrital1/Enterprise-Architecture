package edu.mum.cs.customerReservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservationApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("lab4association2");
        EntityManager em = emf.createEntityManager();

        Reservation reservation = new Reservation();
        reservation.setName("Pool Party");
        Reservation reservation1 = new Reservation();
        reservation1.setName("Dinner");

        Customer customer = new Customer();
        customer.setName("Johnson");
        customer.addReservation(reservation);
        customer.addReservation(reservation1);

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
    }
}
