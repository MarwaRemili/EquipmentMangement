package org.my.multi.module.three.Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author mohamed
 */
@Entity
public class Command implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     private Integer id;

    private String ref;
    
    @OneToOne
    @JoinColumn(name="student_id")        
    private User student;
   
    @ManyToOne
    @JoinColumn(name="eq_id")  
   private Equipement Equipement;
   private int quantity;
   
  
    private String date ;
    
    
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

  

    public Equipement getEquipement() {
        return Equipement;
    }

    public void setEquipement(Equipement Equipement) {
        this.Equipement = Equipement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
}