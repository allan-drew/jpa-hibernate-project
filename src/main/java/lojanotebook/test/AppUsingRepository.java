package lojanotebook.test;

import lojanotebook.model.Notebook;
import lojanotebook.repository.NotebookRepository;

public class AppUsingRepository {

    public static void main(String[] args) {

        // -----------------------------------------------
        // ADICIONAR (CREATE)
//        Notebook notebook = new Notebook();
//        notebook.setMarca("Apple");
//        notebook.setModelo("M1");
//        notebook.setPreco(7590.00);
//
//        NotebookRepository notebookRepository = new NotebookRepository();
//        notebookRepository.adicionarNotebook(notebook);
//        notebookRepository.close();
        //--------------------------------------------


        //--------------------------------------------
        // ENCONTRAR NOTEBOOK (READ)
        Notebook notebook = new Notebook();
        NotebookRepository notebookRepository = new NotebookRepository();
        notebook = notebookRepository.encontrarNotebook(7);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("produto (notebook) encontrado: ");
        System.out.println(notebook);
        System.out.println("------------------------------------------------------------------------------------------");

        notebookRepository.close();
        //--------------------------------------------


        //--------------------------------------------
        // ATUALIZAR NOTEBOOK (UPDATE)
//        Notebook notebook = new Notebook();
//        NotebookRepository notebookRepository = new NotebookRepository();
//        notebook = notebookRepository.encontrarNotebook(1); // encontrando notebook para poder atualizar
//        notebook.setPreco(6399.99);
//
//        notebookRepository.atualizarNotebook(notebook);
//
//        System.out.println("------------------------------------------------------------------------------------------");
//        System.out.println("produto (notebook) ATUALIZADO: ");
//        System.out.println(notebook);
//        System.out.println("------------------------------------------------------------------------------------------");
//
//        notebookRepository.close();
        //--------------------------------------------



        //--------------------------------------------
        // DELETAR NOTEBOOK (DELETE)
//        Notebook notebook = new Notebook();
//        NotebookRepository notebookRepository = new NotebookRepository();
//        notebook = notebookRepository.encontrarNotebook(3); // encontrando notebook para poder deletar
//
//        notebookRepository.deletarNotebook(notebook);
//
//        System.out.println("------------------------------------------------------------------------------------------");
//        System.out.println("produto (notebook) DELETADO: ");
//        System.out.println(notebook);
//        System.out.println("------------------------------------------------------------------------------------------");
//
//        notebookRepository.close();
        //--------------------------------------------


    }

}
