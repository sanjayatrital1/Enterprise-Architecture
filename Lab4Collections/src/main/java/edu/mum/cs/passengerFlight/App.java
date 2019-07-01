package edu.mum.cs.passengerFlight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String [] args){
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Passenger passenger = new Passenger();
        passenger.setName("Sanjay");
        Flight flight = new Flight();
        flight.setFlightNo("183BA");

        flight.addPassenger(passenger);

        em.persist(passenger);
        em.persist(flight);
        em.getTransaction().commit();
        em.close();

        em= emf.createEntityManager();
        em.getTransaction().begin();

        List<Flight> flightList = em.createQuery("from flight ",Flight.class).getResultList();
        for(Flight f: flightList){
            System.out.println("Name= "+f.getPassengerList().toString()+"Flight No= "+f.getFlightNo());
        }
        em.getTransaction().commit();
        em.close();

    }
}
