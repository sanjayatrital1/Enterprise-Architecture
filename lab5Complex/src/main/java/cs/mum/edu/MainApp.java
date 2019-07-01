package cs.mum.edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.util.List;

public class MainApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Doctor doctor = new Doctor();
        doctor.setFirstname("Sanjaya");
        doctor.setLastname("Trital");
        doctor.setDoctortype("General Physician");

        Patient patient = new Patient();
        patient.setName("John");
        patient.setCity("Fairfield");
        patient.setStreet("1000N 4th");
        patient.setZip("52557");

        Payment payment = new Payment();
        payment.setAmount(5000);
        payment.setPaydate("06/24/2019");

        Appointment appointment = new Appointment();
        appointment.setAppdate("04/21/2019");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setPayment(payment);

//        em.persist(doctor);
//        em.persist(patient);
//        em.persist(payment);
        em.persist(appointment);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Appointment> appointmentList = em.createQuery("from Appointment ", Appointment.class).getResultList();
        for(Appointment a: appointmentList){
            System.out.println(a);
        }
        em.getTransaction().commit();
        em.close();
    }
}
