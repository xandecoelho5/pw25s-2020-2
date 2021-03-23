package br.edu.utfpr.pb.pw25s.aula4.controller;

import br.edu.utfpr.pb.pw25s.aula4.model.Livro;
import br.edu.utfpr.pb.pw25s.aula4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private EditoraService editoraService;
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public String list( Model model ) {
        model.addAttribute("livros", livroService.findAll());
        return "livro/list";
    }

    @GetMapping({"new", "novo"})
    public String form( Model model) {
        model.addAttribute("livro", new Livro());
        carregarCombos(model);
        return "livro/form";
    }

    private void carregarCombos(Model model) {
        model.addAttribute("autores", autorService.findAll() );
        model.addAttribute("editoras", editoraService.findAll() );
        model.addAttribute("cidades", cidadeService.findAll() );
        model.addAttribute("generos", generoService.findAll() );
    }

    @PostMapping
    public String save(@Valid Livro livro, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("livro", livro);
            carregarCombos(model);
            return "livro/form";
        }
        livroService.save(livro);
        attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
        return "redirect:/livro";
    }

    @GetMapping("{id}")
    public String form(@PathVariable Long id, Model model) {
        model.addAttribute("livro", livroService.findOne(id));
        carregarCombos(model);
        return "livro/form";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        try {
            livroService.delete(id);
            attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("erro", "Falha ao remover registro");
        }
        return "redirect:/livro";
    }
}
