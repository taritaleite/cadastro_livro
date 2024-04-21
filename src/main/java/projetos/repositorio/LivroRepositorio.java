package projetos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.entidade.LivroEntidade;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepositorio extends JpaRepository<LivroEntidade, Long> {

    List<LivroEntidade> findAll();

    Optional<LivroEntidade> findByIsbn(String isbn);

    boolean existsById(Long id);
}

