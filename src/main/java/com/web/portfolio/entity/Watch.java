package com.web.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Watch {

    @Id
    private Long id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "investor_id", referencedColumnName = "id")
    @JsonIgnoreProperties("Watchs")
    private Investor investor;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = {
                @JoinColumn(name = "watch_id",
                         nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "tstock_id",
                         nullable = false, updatable = false)
            }
    )
    @JsonIgnoreProperties("Watchs")
    private Set<TStock> tStocks = new LinkedHashSet();

    public Watch() {
    }

    public Watch(String name, Investor investor) {
        this.name = name;
        this.investor = investor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Set<TStock> gettStocks() {
        return tStocks;
    }

    public void settStocks(Set<TStock> tStocks) {
        this.tStocks = tStocks;
    }
    
    
}
