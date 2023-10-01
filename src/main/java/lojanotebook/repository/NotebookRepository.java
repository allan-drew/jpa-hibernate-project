package lojanotebook.repository;

import lojanotebook.model.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
O JPA (Java Persistence API) é uma especificação que define uma interface comum para frameworks de persistência de dados em Java.
As principais classes e interfaces do JPA incluem: EntityManager, EntityManagerFactory, Query, TypedQuery, CriteriaBuilder, CriteriaQuery
 */

public class NotebookRepository {

    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public NotebookRepository () {
        this.emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        this.entityManager = this.emf.createEntityManager();
    }


    public Notebook adicionarNotebook (Notebook notebook) {
        entityManager.getTransaction().begin();
        entityManager.persist(notebook);
        entityManager.getTransaction().commit();
        return notebook;
    }

    public Notebook encontrarNotebook (Integer id) {
        return entityManager.find(Notebook.class, id);
    }

    public Notebook atualizarNotebook (Notebook notebook) {
        Notebook notebookToUpdate = encontrarNotebook(notebook.getId());

        entityManager.getTransaction().begin();
        notebookToUpdate.setMarca(notebook.getMarca());
        notebookToUpdate.setModelo(notebook.getModelo());
        notebookToUpdate.setPreco(notebook.getPreco());
        entityManager.getTransaction().commit();
        return notebookToUpdate;
    }

    public void deletarNotebook (Notebook notebook){
        entityManager.getTransaction().begin();
        entityManager.remove(notebook);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }


}
