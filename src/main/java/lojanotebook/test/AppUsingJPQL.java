package lojanotebook.test;

/*
Definição: o JPQL (Java Persistence Query Language) faz parte do JPA (Java Persistence API).
    JPQL é uma linguagem de consulta baseada em SQL, mas orientada a objetos, que permite consultar entidades JPA diretamente.
    JPQL segue uma sintaxe similar ao SQL, mas opera em entidades Java ao invés de tabelas de banco de dados.
    Exemplo: você seleciona e filtra entidades e propriedades usando o nome das classes e atributos Java, não os nomes das tabelas e colunas no banco de dados.

    Com JPQL, você trabalha com objetos e não com o banco de dados diretamente.
    Isso significa que as consultas são independentes do banco de dados subjacente e podem ser facilmente portadas entre diferentes fornecedores de persistência.

    JPQL oferece flexibilidade ao escrever consultas complexas que envolvem múltiplas entidades e operações de junção (joins), agregação e filtragem.
    Use JPQL quando precisar escrever consultas para recuperar entidades JPA com base em critérios específicos

        Em muitos casos, você pode acabar utilizando ambos em conjunto.
        Por exemplo, você pode usar o EntityManager para persistir, atualizar ou excluir entidades
        e JPQL para realizar consultas complexas que envolvem múltiplas entidades.

    Algumas das classes e métodos principais do JPQL: Query, TypedQuery, EntityManager
 */

import lojanotebook.model.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

public class AppUsingJPQL {

    // ===================================================================================================================
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // findAllNotebooksInTheStore(em);
        // findNotebookUsingId(em, 7); // procurando pelo notebook de id = 7
        // listarTodosOsModelosDisponiveis(em);
        // listarModelosComPrecos(em);

        em.close();
        emf.close();

    }
    // ===================================================================================================================


    // ------------------------------------------------------------------------------------------------------------------------------------
    public static void findAllNotebooksInTheStore(EntityManager entityManager) {
        String jpql = "select n from Notebook n";
        TypedQuery<Notebook> typedQuery = entityManager.createQuery(jpql, Notebook.class); // TypedQuery é uma consulta query tipada (Typed)
        List<Notebook> list = typedQuery.getResultList(); // RESULT LIST

        for (Notebook notebook: list) {
            System.out.println(notebook);
        }
    }
    // ------------------------------------------------------------------------------------------------------------------------------------


    // ------------------------------------------------------------------------------------------------------------------------------------
    public static void findNotebookUsingId (EntityManager entityManager, Integer id) {
        String jpql = "select n from Notebook n where id = :idNotebook";
        TypedQuery<Notebook> typedQuery = entityManager.createQuery(jpql, Notebook.class).setParameter("idNotebook", id);
        System.out.println(typedQuery.getSingleResult()); // SINGLE RESULT
    }
    // ------------------------------------------------------------------------------------------------------------------------------------


    // ------------------------------------------------------------------------------------------------------------------------------------
    // o método vai listar todos os modelos, sem listar o id, a marca e o preco
    public static void listarTodosOsModelosDisponiveis (EntityManager entityManager) {
        String jpql = "select n.modelo from Notebook n";

        TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);

        List<String> list = typedQuery.getResultList();

        System.out.println("==================================");
        System.out.println("Os modelos disponíveis na loja são: ");
        for (String s: list) {
            System.out.println("   " + s);
        }
        System.out.println("==================================");

    }
    // ------------------------------------------------------------------------------------------------------------------------------------


    // ------------------------------------------------------------------------------------------------------------------------------------
    // método para listar modelos com os respectivos preços, usando projeções!
    // projeções se referem à capacidade de selecionar e retornar apenas um subconjunto específico de dados de uma entidade
    public static void listarModelosComPrecos (EntityManager entityManager) {
        String jpql = "select n.modelo, n.preco from Notebook n";
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();

        for (Object[] s : list) {
            System.out.println(Arrays.toString(s));
        }

    }
    // ------------------------------------------------------------------------------------------------------------------------------------



}
