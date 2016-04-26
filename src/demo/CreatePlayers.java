/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package demo;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Álvaro Rios
 */
public class CreatePlayers {
    
    public static void main(String[] args) {
        System.out.println("1. insertar");
        System.out.println("2. leer");
        System.out.println("3. editar"); 
        System.out.println("4. borrar");
        System.out.println("Ingrese opcion:");
        Scanner e = new Scanner(System.in);
       String opcion = e.next();
       
       if ("insertar".equals(opcion)){
           
           CreatePlayers.insert();
       }
          if ("leer".equals(opcion)){
           
           CreatePlayers.leer();
       }
          if ("editar".equals(opcion)){
           
           CreatePlayers.edit();
       }
            if ("borrar".equals(opcion)){
           
           CreatePlayers.borrar();
       }
       
}
    
   public static void insert(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoPU");
        EntityManager em = emf.createEntityManager();

       em.getTransaction().begin();

        Player p1 = new Player();
        System.out.println("Ingrese Id");
        Scanner id = new Scanner(System.in);
        p1.setId(id.nextInt());
        System.out.println("Ingrese Nombre");
        Scanner nombre = new Scanner(System.in);
        p1.setFirstname(nombre.next());
        System.out.println("Ingrese Apellido");
        Scanner apellido = new Scanner(System.in);
        p1.setLastname(apellido.next());
        System.out.println("Ingrese num camiseta");
        Scanner camiseta = new Scanner(System.in);
        p1.setJerseynumber(camiseta.nextInt());
        System.out.println("Ingrese equipo");
        Scanner equipo = new Scanner(System.in);
        p1.setLastspokenwords(equipo.next());
       
 
    em.persist(p1);
    em.getTransaction().commit();
    em.close();
    emf.close();       
     
   }
   
   public static void leer(){
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoPU");
   EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Player p1 = new Player();
    List<Player> list =em.createNamedQuery("Player.findAll",Player.class).getResultList();
    for(Player p : list){
        System.out.println(p.getId());
        System.out.println(p.getFirstname());
        System.out.println(p.getLastname());
        System.out.println(p.getLastspokenwords());
    }
     em.close();
     emf.close(); 
   }
   
    public static void edit(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoPU");
        EntityManager em = emf.createEntityManager();
        Player p1 = new Player();
        em.getTransaction().begin();
        System.out.println("Ingrese Id");
        Scanner id = new Scanner(System.in);
        p1.setId(id.nextInt());
        System.out.println("Ingrese Nombre");
        Scanner nombre = new Scanner(System.in);
        p1.setFirstname(nombre.next());
        System.out.println("Ingrese Apellido");
        Scanner apellido = new Scanner(System.in);
        p1.setLastname(apellido.next());
        System.out.println("Ingrese num camiseta");
        Scanner camiseta = new Scanner(System.in);
        p1.setId(camiseta.nextInt());
        System.out.println("Ingrese equipo");
        Scanner equipo = new Scanner(System.in);
        p1.setLastspokenwords(equipo.next());
   
   em.merge(p1);
   em.getTransaction().commit();

    
    
     em.close();
     emf.close(); 
   }

    public static void borrar(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoPU");
    EntityManager em = emf.createEntityManager();
    Player p1 = new Player();
    em.getTransaction().begin();
     System.out.println("Ingrese Id para eliminar");
     Scanner id = new Scanner(System.in);
    Player p = em.find(Player.class,id.nextInt());
    em.remove(p);
    em.getTransaction().commit();
    
    
     em.close();
     emf.close(); 
   }
}
