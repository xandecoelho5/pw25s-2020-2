package br.edu.utfpr.pb.pw25s.aula4.service.impl;

import br.edu.utfpr.pb.pw25s.aula4.model.Cidade;
import br.edu.utfpr.pb.pw25s.aula4.repository.CidadeRepository;
import br.edu.utfpr.pb.pw25s.aula4.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CidadeServiceImpl extends CrudServiceImpl<Cidade, Long> implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    protected JpaRepository<Cidade, Long> getRepository() { return cidadeRepository; }
}