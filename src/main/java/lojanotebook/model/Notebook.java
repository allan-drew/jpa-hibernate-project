package lojanotebook.model;

import javax.persistence.*;
import java.util.Objects;


@Entity // marca a classe como uma entidade JPA. Logo, os objetos dessa classe podem ser persistidos em um banco de dados.
@Table(name = "notebook")
public class Notebook {

    @Id // indica que o campo id é a chave primária da entidade.
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String marca;

    private String modelo;

    private Double preco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return id.equals(notebook.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Notebook {" + '\n' +
                "   id = " + id + '\n' +
                "   marca = " + marca + '\n' +
                "   modelo = " + modelo + '\n' +
                "   preco = " + preco + '\n' +
                '}';
    }

}
