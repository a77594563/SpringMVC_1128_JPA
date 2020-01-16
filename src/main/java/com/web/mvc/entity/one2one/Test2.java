package com.web.mvc.entity.one2one;

import com.web.mvc.entity.JPAUtil;
import javax.persistence.EntityManager;

public class Test2 {
    static EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    public static void main(String[] args) {
        add("John", "Mary");
        add("Tom", "Jane");
    }
    
        public static void add(String name1, String name2) {
        Husband husband = new Husband();
        husband.setName(name1);
        
        Wife wife = new Wife();
        wife.setName(name2);
        
        husband.setWife(wife);
        
        em.getTransaction().begin();
        em.persist(husband);
        em.getTransaction().commit();
        System.out.println("Add OK !");
    }
}
