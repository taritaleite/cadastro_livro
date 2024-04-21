package projetos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;
import projetos.entidade.LivroEntidade;

import java.time.LocalDate;
import java.util.Date;

public class LivroDTO {

    @NotBlank(message = "O título não pode estar vazio.")
    @Size(max = 200, message = "O título não pode ter mais de 200 caracteres.")
    private String titulo;

    @NotBlank(message = "O título não pode estar vazio.")
    @Size(max = 4000, message = "A descrição deve ter entre 1 e 500 caracteres.")
    private String descricao;

    @NotBlank(message = "A edição não pode estar vazia.")
    private String edicao;

    @NotBlank(message = "O ISBN não pode estar vazio.")
    @ISBN
    @Size(min = 10, max = 13, message = "O ISBN deve ter entre 10 e 13 caracteres.")
    private String isbn;

    @NotNull(message = "A data de publicação não pode ser nula.")
    @Past(message = "A data de publicação deve estar no passado.")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPublicacao;

    public LivroDTO() {
    }

    public LivroDTO(String titulo, String descricao, String edicao, String isbn, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.edicao = edicao;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
    }

    public static LivroDTO toLivroDTO(LivroEntidade livroEntidade) {
        return new LivroDTO(
                livroEntidade.getTitulo(),
                livroEntidade.getDescricao(),
                livroEntidade.getEdicao(),
                livroEntidade.getIsbn(),
                livroEntidade.getDataPublicacao()
        );
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
