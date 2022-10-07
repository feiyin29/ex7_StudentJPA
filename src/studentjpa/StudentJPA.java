/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author feifei
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Student stu1 = new Student(1, "taeyoung", 3.5);
        Student stu2 = new Student(2, "jeno", 3.8);
        persist(stu1);
        persist(stu2);
        */
        ///*
        Student stu;
        stu = StudentTable.findStudentById(2);
        if (stu != null) {
            stu.setName("jaemin");
            //StudentTable.removeStudent(stu);
            StudentTable.updateStudent(stu);
        }
        //*/
        //List<Student> stuList = StudentTable.findStudentByName("jaemin"); 
        List<Student> stuList = StudentTable.findAllStudent();
        printAllStudent(stuList);
    }
    public static void printAllStudent(List<Student> studentList) {
        for(Student stu : studentList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
