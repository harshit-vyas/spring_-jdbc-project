package com.springjdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        Student st = new Student();
//        st.setRoll(16);st.setName("rajveer");st.setCourse("bcom");
         ApplicationContext cnt = new ClassPathXmlApplicationContext("com/springjdbc/springjdbc/config.xml");
        StudentDao dao = (StudentDao)cnt.getBean("st");
//        Boolean stu = dao.saveStudent(st);
//        System.out.println(stu);
        Boolean b = dao.updatestu(14);
        Boolean bool = dao.delete(15);
        List<Student> l = dao.getAllStu();
        for(Student s : l) {
        	System.out.println(s.getRoll()+" "+s.getName()+" "+s.getCourse());
        }
        System.out.println("hello");
    }
}
