/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica03;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author juan
 */
public class HibernateUtil {
    public static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            
                Configuration configuration= new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://172.17.0.2:5432/tienda");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "123456");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                
                
                /// Agregar los pojos como entity
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(DetVenta.class);
                configuration.addAnnotatedClass(Venta.class);
                configuration.addAnnotatedClass(Producto.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
        }
        return sessionFactory;
    }
    
    public static Session getSession() throws HibernateException{
        if(sessionFactory==null){
            getSessionFactory();
        }
        return sessionFactory.openSession();
    }
    
    public static void shutdown(){
        if(sessionFactory!=null){
            sessionFactory.close();
        }
    }
}
