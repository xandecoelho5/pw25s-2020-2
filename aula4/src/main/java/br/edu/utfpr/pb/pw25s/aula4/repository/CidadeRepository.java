package br.edu.utfpr.pb.pw25s.aula4.repository;

import br.edu.utfpr.pb.pw25s.aula4.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
}