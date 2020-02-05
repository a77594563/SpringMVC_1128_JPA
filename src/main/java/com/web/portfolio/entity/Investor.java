package com.web.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Investor {

    @Id
    private Long id;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    @Column
    private String username;
    
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy = "investor")
    @JsonIgnoreProperties("investor")
    private Set<Portfolio> portfolios;
    
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy = "investor")
    @JsonIgnoreProperties("investor")
    private Set<Watch> watchs;

    public Investor() {
    }

    public Investor(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
