package lojanotebook.test;

/*
A Criteria API é uma funcionalidade do JPA (Java Persistence API)
que permite criar consultas de banco de dados de forma programática usando código Java,
em vez de escrever consultas JPQL (Java Persistence Query Language) diretamente como strings.

CriteriaBuilder -> interface principal da API. Usada para criar instâncias de objetos CriteriaQuery, Predicate, e outras classes relacionadas.
CriteriaQuery -> interface que representa a consulta em si.
Predicate -> condições usadas para restringir os resultados da consulta.
Root -> entidade principal da consulta.
EntityManager -> interface que gerencia a persistência das entidades. Fornece métodos para persistir, recuperar, atualizar e excluir objetos do banco de dados.

 */

import lojanotebook.model.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AppUsingCriteria {


    // ===================================================================================================================
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        //findAllNotebooksInTheStore(em);
        // findNotebookUsingId(em, 2); // procurando pelo notebook de id = 2
        listarTodosOsModelosDisponiveis(em);

        em.close();
        emf.close();

    }
    // ===================================================================================================================


    // ------------------------------------------------------------------------------------------------------------------------------------
    public static void findAllNotebooksInTheStore(EntityManager entityManager) {

        // Criteria API:
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> criteriaQuery = cb.createQuery(Notebook.class);
        Root<Notebook> r = criteriaQuery.from(Notebook.class);
        criteriaQuery.select(r);
        //

        TypedQuery<Notebook> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Notebook> list = typedQuery.getResultList();

        for (Notebook notebook: list) {
            System.out.println(notebook);
        }
    }
    // ------------------------------------------------------------------------------------------------------------------------------------


    // ------------------------------------------------------------------------------------------------------------------------------------
    public static void findNotebookUsingId (EntityManager entityManager, Integer id) {

        // Criteria API:
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> criteriaQuery = cb.createQuery(Notebook.class);
        Root<Notebook> r = criteriaQuery.from(Notebook.class);
        criteriaQuery.select(r).where(cb.equal(r.get("id"), id));
        //

        TypedQuery<Notebook> typedQuery = entityManager.createQuery(criteriaQuery);
        System.out.println(typedQuery.getSingleResult());
    }
    // ------------------------------------------------------------------------------------------------------------------------------------


    // ------------------------------------------------------------------------------------------------------------------------------------
    public static void listarTodosOsModelosDisponiveis (EntityManager entityManager) {

        // Criteria API:
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = cb.createQuery(String.class);
        Root<Notebook> r = criteriaQuery.from(Notebook.class);
        criteriaQuery.select(r.get("modelo"));
        //

        TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);

        List<String> list = typedQuery.getResultList();

        System.out.println("==================================");
        System.out.println("Os modelos disponíveis na loja são: ");
        for (String s: list) {
            System.out.println("   ---> " + s);
        }
        System.out.println("==================================");

    }
    // ------------------------------------------------------------------------------------------------------------------------------------



}
