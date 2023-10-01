package lojanotebook.test;


import lojanotebook.model.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppNotUsingRepository {

    public static void main(String[] args) {

        // EntityManagerFactory é uma interface fornecida pelo Java Persistence API (JPA)
        // que representa uma fábrica para a criação de instâncias de EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa"); // persistence-unit name pode ser encontrado no persistence.xml

        // EntityManager é uma interface do Java Persistence API (JPA) que fornece um conjunto de métodos para realizar operações
        // de persistência em entidades (objetos mapeados para o banco de dados).
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // READ (FIND)
//        Notebook notebook = entityManager.find(Notebook.class, 4);
//        System.out.println("----------------------------------------------------------------------------------------------------");
//        System.out.println("Notebook encontrado => " + notebook.getMarca() + " " + notebook.getModelo());
//        System.out.println("----------------------------------------------------------------------------------------------------");
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // CREATE (INSERT / PERSIST)
//        Notebook notebook = new Notebook();
//        // notebook.setId(6); // com o @GeneratedValue(strategy= GenerationType.IDENTITY), o id é autogerado pelo banco
//        notebook.setMarca("ASUS");
//        notebook.setModelo("Zenbook 14");
//        notebook.setPreco(4879.99);
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(notebook);
//        entityManager.getTransaction().commit();
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // DELETE (REMOVE)
//        Notebook notebook = entityManager.find(Notebook.class, 5); // procurando o notebook com o id de 5 (SELECT)
//        entityManager.getTransaction().begin();
//        entityManager.remove(notebook); // removendo o notebook encontrado (DELETE)
//        entityManager.getTransaction().commit();
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // UPDATE
//        Notebook notebook = entityManager.find(Notebook.class, 1); // procurando o notebook com o id de 1 (SELECT)
//        entityManager.getTransaction().begin();
//        notebook.setPreco(6299.00); // fazendo o update do notebook encontrado (UPDATE)
//        entityManager.getTransaction().commit();
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // para casos de registros ainda não geranciados pelo JPA (por exemplo, quando recebe através da web), pode-se usar o merge
//        Notebook notebook = new Notebook();
//        notebook.setId(4); // como estamos passando um setId, então o JPA irá fazer um update pois o id existe no banco de dados
//        notebook.setMarca("Apple");
//        notebook.setModelo("Macbook Air M2");
//        notebook.setPreco(9499.99);
//
//        entityManager.getTransaction().begin();
//        entityManager.merge(notebook);
//        entityManager.getTransaction().commit();
        // --------------------------------------------------------------------------------------------------------------------------------------------------------


        entityManager.close();
        entityManagerFactory.close();

    }

}
