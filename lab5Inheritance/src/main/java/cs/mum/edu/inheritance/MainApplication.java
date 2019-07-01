package cs.mum.edu.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MainApplication {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws ParseException {
        emf = Persistence.createEntityManagerFactory("inheritance");
        EntityManager em = emf.createEntityManager();

        Customer customer1= new Customer();
        customer1.setFirstName("Sanjaya");
        customer1.setLastName("Trital");

        CD product1 = new CD();
        product1.setName("Iphone");
        product1.setDescription("abcdefgh");
        product1.setArtist("Sakira");

        DVD product2 = new DVD();
        product2.setName("Captain America");
        product2.setDescription("Action");
        product2.setGenre("zzzzzzzzzzzzz");

        Book product3 = new Book();
        product3.setTitle("aaaaaaaaaaaaaaa");
        product3.setName("EA");
        product3.setDescription("Enterprise Architecture");


        OrderLine orderLine1 = new OrderLine();
        orderLine1.setProduct(product1);
        orderLine1.setProduct(product2);
        orderLine1.setProduct(product3);
        orderLine1.setQuantity(5);

        Order order1 = new Order();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
        order1.setDate(sf.parse("2019-5-8"));
        order1.setCustomer(customer1);
        order1.addOrderLine(orderLine1);

        em.getTransaction().begin();
        em.persist(customer1);
        em.persist(product1);
        em.persist(orderLine1);
        em.persist(order1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Order> result = em.createQuery("from Order ", Order.class).getResultList();
        for(Order o: result){
            System.out.println(" Customer Name: "+o.getCustomer().getFirstName()+" "+o.getCustomer().getLastName()+" Date: "
                    +o.getDate()+"order: "+o.getOrderLine().toString());
        }

    }

}
