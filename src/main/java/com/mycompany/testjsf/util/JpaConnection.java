package com.mycompany.testjsf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnection {

    private static final String PERSISTENCE_UNIT = "SFCS";
    private static EntityManager em;
    private static EntityManagerFactory factory;

    //Cria a persistência de dados em meu banco de dados
    public static EntityManager getEntityManager(){
        if(em == null || !factory.isOpen())
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

        if(em == null || !em.isOpen())
            em = factory.createEntityManager();

        return em;
    }

    public static void closeEntityManager(){
        if(em != null && em.isOpen())
            em.close();
    }

}
