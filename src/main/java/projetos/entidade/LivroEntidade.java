package projetos.entidade;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import projetos.dto.LivroDTO;

import java.time.LocalDate;

@Entity
@Table(name = "tb_livros")
public class LivroEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    private String descricao;

    private String edicao;

    private String isbn;

    @Column(name = "DATAPUBLICACAO", columnDefinition = "DATE")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPublicacao;

    public LivroEntidade() {
    }

    public LivroEntidade(LivroDTO livroDTO) {
        this.titulo = livroDTO.getTitulo();
        this.descricao = livroDTO.getDescricao();
        this.edicao = livroDTO.getEdicao();
        this.isbn = livroDTO.getIsbn();
        this.dataPublicacao = livroDTO.getDataPublicacao();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
}
