package br.edu.utfpr.pb.pw25s.aula4.service.impl;

import br.edu.utfpr.pb.pw25s.aula4.model.Autor;
import br.edu.utfpr.pb.pw25s.aula4.repository.AutorRepository;
import br.edu.utfpr.pb.pw25s.aula4.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends CrudServiceImpl<Autor, Long> implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    protected JpaRepository<Autor, Long> getRepository() { return autorRepository; }
}
