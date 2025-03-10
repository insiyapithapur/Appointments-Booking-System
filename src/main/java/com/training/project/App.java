package com.training.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.math.BigDecimal;
import java.util.List;

import com.training.project.util.HibernateUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            // Load Hibernate session factory
        	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

            // Open session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Run a simple query
            String sql = "SELECT 1 FROM DUAL";  // Oracle test query
            BigDecimal result = (BigDecimal) session.createNativeQuery(sql).getSingleResult();
            
            String tablesSql = "SELECT table_name FROM user_tables ORDER BY table_name";
            @SuppressWarnings("unchecked")
            List<Object> tablesList = session.createNativeQuery(tablesSql).getResultList();
            
            // Display the tables
            System.out.println("\nYour database tables:");
            System.out.println("--------------------");
            if (tablesList.isEmpty()) {
                System.out.println("No tables found for current user.");
            } else {
                for (Object tableNameObj : tablesList) {
                    String tableName = tableNameObj.toString();
                    System.out.println(tableName);
                }
                System.out.println("\nTotal tables: " + tablesList.size());
            }
            
            System.out.println("Hibernate is connected to Oracle! Query Result: " + result);

            // Close session
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to Oracle!");
        }
        
    }
}
