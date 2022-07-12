package com.example.consultorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAO<E> {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<E> classe;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("consultorio");
        } catch (Exception e) {
            System.out.printf("deu erro");
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        entityManager = entityManagerFactory.createEntityManager();

    }

    public DAO<E> abriTransition() {
        entityManager.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransition() {
        entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> persistir(E entidade) {
        entityManager.persist(entidade);
        return this;
    }

    public DAO<E> persistirCompleto(E entidade) {
        return this.abriTransition().persistir(entidade).fecharTransition();
    }
}