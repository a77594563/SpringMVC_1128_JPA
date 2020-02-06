package com.web.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Portfolio {

    @Id
    private Long id;
    
    @Column
    private Integer amount;
    
    @Column
    private Double cost;
    
    @Column
    private Date date = new Date();
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "investor_id", referencedColumnName = "id")
    @JsonIgnoreProperties("portfolios")
    private Investor investor;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tstock_id", referencedColumnName = "id")
    @JsonIgnoreProperties("portfolios")
    private TStock tstock;

    public Portfolio() {
    }

    
    public Portfolio(Long id, Integer amount, Double cost, Investor investor) {
        this.id = id;
        this.amount = amount;
        this.cost = cost;
        this.investor = investor;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public TStock getTstock() {
        return tstock;
    }

    public void setTstock(TStock tstock) {
        this.tstock = tstock;
    }

    @Override
    public String toString() {
        return "Portfolio{" + "id=" + id + ", amount=" + amount + ", cost=" + cost + ", date=" + date + '}';
    }
        
}
