package com.web.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity        
public class Classify {

    @Id
    private Long id;
    
    @Column
    private String name;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "classify")
    @JsonIgnoreProperties("classify")
    private Set<TStock> tStocks;
    
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

    public Set<TStock> gettStocks() {
        return tStocks;
    }

    public void settStocks(Set<TStock> tStocks) {
        this.tStocks = tStocks;
    }
    
    
}
