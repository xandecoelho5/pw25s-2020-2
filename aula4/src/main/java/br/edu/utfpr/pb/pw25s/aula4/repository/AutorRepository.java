package br.edu.utfpr.pb.pw25s.aula4.repository;

import br.edu.utfpr.pb.pw25s.aula4.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}