package edu.mum.cs544;

import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Airport;
import edu.mum.cs544.model.Flight;
import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A:");
        List<Flight> flights = em.createQuery("select distinct f from Flight as f" +
                " join f.airplane as a " +
                "join f.origin as o " +
                "join f.destination as d" +
                " where o.country= 'USA' and a.capacity > 500 and d.country !='USA'", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // b) TODO: All airlines that use A380 airplanes
        System.out.println("Question B:");
        List<Airline> airlines = em.createQuery("select distinct a from Airline as a " +
                "join a.flights as f " +
                "where f.airplane.model='A380'", Airline.class).getResultList();
        System.out.println("Airlines that use A380s:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C:");
        flights = em.createQuery("select f from Flight as f " +
                "join f.airplane as a " +
                "join f.airline as air " +
                "where a.model='747' and air.name !='Star Alliance'", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        TypedQuery<Flight> query = em.createQuery("select f from Flight as f" +
                " where f.departureTime < '12:00:00' and f.departureDate = '2009-08-07'", Flight.class);
        flights = query.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();

        System.out.println("====================================================================================");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Airport> flightTypedQuery = em.createQuery("select a from Airport a left join a.arrivals ar left join a.departures ad",Airport.class);
        List<Airport> airportList = flightTypedQuery.getResultList();
        for(Airport a: airportList){
            System.out.printf("%-7s  %8s  %-12s %7s %8s\n",a.getCity(),a.getAirportcode(),
                    a.getCountry(),a.getName(),a.getAirportcode());

        }
        em.getTransaction().commit();
        em.close();
    }
}
