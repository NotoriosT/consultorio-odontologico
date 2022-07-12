package com.example.consultorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAO<E> {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<E>  classe;
    static {
        try {
            entityManagerFactory= Persistence.createEntityManagerFactory("consultorio");
        }catch (Exception e){
            System.out.printf("deu erro");
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe){
        this.classe=classe;
        entityManager=entityManagerFactory.createEntityManager();

    }
    public DAO<E> abriTransition(){
        entityManager.getTransaction().begin();
        return this;
    }
    public DAO<E> fecharTransition(){
        entityManager.getTransaction().commit();
        return this;
    }
    public DAO<E> persistir(E entidade){
        entityManager.persist(entidade);
        return this;
    }
    public DAO<E> persistirCompleto(E entidade){
        return this.abriTransition().persistir(entidade).fecharTransition();
    }

/*   public List<E> obterTodos(int quat, int deslocamento){
        if (classe==null){
            throw new UnsupportedOperationException("clase nula");
        }
        String jpql="Select p from Pokemon p ";
        TypedQuery<E> eTypedQuery=entityManager.createQuery(jpql, classe);
        eTypedQuery.setMaxResults(quat);
        eTypedQuery.setFirstResult(deslocamento);
        return eTypedQuery.getResultList();
    }*/

   public List<Agenda>obterTodos(){
        if (classe==null){
            throw new UnsupportedOperationException("clase nula");
        }
        String jpql="Select p from Agenda p  ";
        TypedQuery<E> eTypedQuery=entityManager.createQuery(jpql, classe);
        return (List<Agenda>) eTypedQuery.getResultList();
    }
  /*  public List<E> TipoBusca(String tipo){
        String jpql="Select p from Pokemon p join fetch p.tipoPokemons f where f.nome like :parame";
        TypedQuery<E> eTypedQuery=entityManager.createQuery(jpql, classe).setParameter("parame",tipo+"%");
        List<E> list=eTypedQuery.getResultList();

        return list;
    }*/

  /*  public boolean delete(int id){

        Pokemon pokemon=  entityManager.find(Pokemon.class,id);

        if (pokemon!=null){
            System.out.println(pokemon.getNome());

            entityManager.getTransaction().begin();
            entityManager.remove(pokemon);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }*/

    public Paciente buscaId(int id){

        if (classe==null){
            throw new UnsupportedOperationException("clase nula");
        }
        String jpql="Select p from Paciente p where p.id= :parame";
        TypedQuery<E> eTypedQuery=entityManager.createQuery(jpql, classe).setParameter("parame",id);
        List<E> list=eTypedQuery.getResultList();
        return (Paciente) eTypedQuery.getSingleResult();
    }
    public void fechar(){
        entityManager.close();
    }

    public Procedimento buscaProcedimento(int id){

        if (classe==null){
            throw new UnsupportedOperationException("clase nula");
        }
        String jpql="Select p from Procedimento p where p.id= :parame";
        TypedQuery<E> eTypedQuery=entityManager.createQuery(jpql, classe).setParameter("parame",id);
        List<E> list=eTypedQuery.getResultList();
        return (Procedimento) eTypedQuery.getSingleResult();
    }
    public Agenda buscaAgenda(int id){

        if (classe==null){
            throw new UnsupportedOperationException("clase nula");
        }
        String jpql="Select p from Agenda p where p.id= :parame";
        TypedQuery<E> eTypedQuery=entityManager.createQuery(jpql, classe).setParameter("parame",id);
        List<E> list=eTypedQuery.getResultList();
        return (Agenda) eTypedQuery.getSingleResult();
    }

}