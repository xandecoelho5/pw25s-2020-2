package br.edu.utfpr.pb.pw25s.aula4.service.impl;

import br.edu.utfpr.pb.pw25s.aula4.model.Editora;
import br.edu.utfpr.pb.pw25s.aula4.repository.EditoraRepository;
import br.edu.utfpr.pb.pw25s.aula4.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EditoraServiceImpl extends CrudServiceImpl<Editora, Long> implements EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    @Override
    protected JpaRepository<Editora, Long> getRepository() { return editoraRepository; }
}