package com.web.portfolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.mvc.entity.JPAUtil;
import com.web.portfolio.entity.Classify;
import com.web.portfolio.entity.Investor;
import com.web.portfolio.entity.Portfolio;
import com.web.portfolio.entity.TStock;
import com.web.portfolio.entity.Watch;
import javax.persistence.EntityManager;

public class Test {

    static EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    static ObjectMapper obj = new ObjectMapper();

    public static void main(String[] args) {
        init();
    }
    
    private static void init() {
        Investor investor01 = new Investor("Join", "1234", "Join@gmail.com", 10000000);
        Investor investor02 = new Investor("Peggy", "1111", "Peggy@gmail.com", 10000000);
        Investor investor03 = new Investor("Sady", "4321", "Sady@gmail.com", 10000000);
        
        Classify classify01 = new Classify("股票", true);
        Classify classify02 = new Classify("匯率", true);
        Classify classify03 = new Classify("指數", false);
        
        TStock ts1 = new TStock("2330.TW", "台積電", classify01);
        TStock ts2 = new TStock("2317.TW", "鴻海", classify01);
        TStock ts3 = new TStock("1101.TW", "台泥", classify01);
        
        TStock ts4 = new TStock("USDTWD=x", "美金台幣", classify02);
        TStock ts5 = new TStock("JPYTWD=x", "日幣台幣", classify02);
        TStock ts6 = new TStock("CNYTWD=x", "人民幣台幣", classify02);
        
        TStock ts7 = new TStock("^TWII", "台灣加權", classify03);
        TStock ts8 = new TStock("^IXIC", "納斯達克", classify03);
        TStock ts9 = new TStock("^DJI", "道瓊工業", classify03);
        
        Portfolio portfolio1 = new Portfolio(60.5, 2000, investor01, ts1);
        Portfolio portfolio2 = new Portfolio(35.5, 5000, investor01, ts2);
        
        Watch watch = new Watch();
        watch.addtStock(ts1);
        watch.addtStock(ts2);
        watch.addtStock(ts4);
        watch.addtStock(ts6);
        watch.addtStock(ts7);
        watch.addtStock(ts9);
        watch.setInvestor(investor01);
        watch.setName("我的觀察股");
        
        em.getTransaction().begin();
        em.persist(ts1);
        em.persist(ts2);
        em.persist(ts3);
        em.persist(ts4);
        em.persist(ts5);
        em.persist(ts6);
        em.persist(ts7);
        em.persist(ts8);
        em.persist(ts9);
        em.persist(investor01);
        em.persist(investor02);
        em.persist(portfolio1);
        em.persist(portfolio2);
        em.persist(watch);
        em.getTransaction().commit();
        
        System.out.println("OK");
    }
}
