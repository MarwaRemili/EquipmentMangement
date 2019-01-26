/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.multi.module.three.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.my.multi.module.three.Entities.Student;
import org.springframework.stereotype.Service;


/**
 *
 * @author marwa
 */
@Transactional
@Service
public class StudentServices {
    @PersistenceContext
    private EntityManager em;
    
    public void addNewStudent(Student st){
        em.persist(st);
    }
    
    public Student getStudentById(int id){
        return em.find(Student.class, id);
    }
    public void updateStudent(Student st){
        em.merge(st);
    }
    public List <Student> getAllStudents(){
        Query query=em.createQuery("from Student st");
        return query.getResultList();
    }
    public void removeStudentById(int studentId){
        Student st=em.find(Student.class, studentId);
        em.remove(st);
    }
    
    
    
    
}
