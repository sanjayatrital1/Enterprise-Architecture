package edu.mum.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import edu.mum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class Main {

//    UserService userService;
public static ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");


    public static UserService userService = (UserService) ctx.getBean("userServiceImpl");


  public static void main(String[] args) {
      Main m = new Main();


      List<User> userList = userService.findAll();
      User user = new User();
      user.setFirstName("John");
      user.setLastName("Doe");
      user.setEmail("dongj@mum.edu");
      //user.setId((long) 1);
      user.setAdmin(true);
      user.setRating(4);
      user.setVersion(2);
      try {
          user.setLastLogin(new SimpleDateFormat("dd/mm/yyyy").parse("2/4/2018"));
      } catch (ParseException e) {
          e.printStackTrace();
      }
      userService.save(user);
      m.display();
      user.setFirstName("Tom");
      userService.update(user);
      m.display();

      User displayUser = userService.findByEmail("dongj@mum.edu");

      System.out.println("        *********  USER **********");

      System.out.println("User Name: " + displayUser.getFirstName() + " " + displayUser.getLastName());

//      m.update();
//      m.display();



  }

  public void update(){
   User u = new User();
      u.setFirstName("Peter");
      u.setLastName("Cruz");
      u.setEmail("peter@mum.edu");
      try {
          u.setLastLogin(new SimpleDateFormat("dd/mm/yyyy").parse("20/4/2016"));
      } catch (ParseException e) {
          e.printStackTrace();
      }
      userService.update(u);
  }

  public void display(){
      List<User> uList = userService.findAll();
      for(User u: uList){
          System.out.println("Name: "+u.getFirstName()+" "+u.getLastName());
      }
  }

 }