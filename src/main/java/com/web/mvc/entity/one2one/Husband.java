package com.web.mvc.entity.one2one;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Husband")
public class Husband{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wife_id") //較常見
    /*@JoinColumns(
            {
                @JoinColumn( name = "wife_id", referencedColumnName = "id"),
                @JoinColumn( name = "wife_name", referencedColumnName = "name")
            }
    )*/ //較少見
    //可加入 SQL 外鍵約束 SQL
    //ALTER TABLE APP.HUSBAND ADD CONSTRAINT FK_WIFE FOREIGN KEY (WIFE_ID) REFERENCES APP.WIFE(ID);        
    //可移除 SQL 外鍵約束 SQL
    //ALTER TABLE APP.HUSBAND DROP CONSTRAINT FK_WIFE;    
    private Wife wife;

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

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
    
}