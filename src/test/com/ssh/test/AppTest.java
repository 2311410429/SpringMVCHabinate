package com.ssh.test;

import com.ssh.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/27.
 */
public class AppTest {
    @Test
    public void fun(){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory= (SessionFactory) act.getBean("sqlSessionFactory");
        Session session1 = sessionFactory.openSession();
        Session session2=sessionFactory.openSession();
        System.out.println(session1==session2);
//        sessionFactory.openSession();
//        Session session=sessionFactory.getCurrentSession();
    }
    @Test
    public void fun1(){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory= (SessionFactory) act.getBean("sqlSessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Dept dept=new Dept();
            dept.setDeptno(2);
            dept.setDname("asd");
            dept.setLoc("zxcv");
            session.persist(dept);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        
    }
}

