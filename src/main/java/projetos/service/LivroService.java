package projetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetos.dto.LivroDTO;
import projetos.entidade.LivroEntidade;
import projetos.excecoes.LivroException;
import projetos.repositorio.LivroRepositorio;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepositorio repositorio;

    public LivroDTO salvarNovoLivro(LivroDTO livroDTO) {

        verificarSeLivroExiste(livroDTO.getIsbn());

        LivroEntidade livro = new LivroEntidade(livroDTO);

        repositorio.save(livro);

        return LivroDTO.toLivroDTO(livro);
    }

    private void verificarSeLivroExiste(String isbn) {
        Optional<LivroEntidade> livroExistente = repositorio.findByIsbn(isbn);

        if (livroExistente.isPresent()) {
            throw new LivroException("Já existe um livro cadastrado com o ISBN informado.");
        }
    }
}