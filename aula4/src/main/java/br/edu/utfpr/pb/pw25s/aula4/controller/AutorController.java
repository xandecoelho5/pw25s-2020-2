package br.edu.utfpr.pb.pw25s.aula4.controller;

import br.edu.utfpr.pb.pw25s.aula4.model.Autor;
import br.edu.utfpr.pb.pw25s.aula4.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("autores", autorService.findAll());
        return "autor/list";
    }

    @GetMapping(value = {"new", "novo", "form"})
    public String form(Model model) {
        model.addAttribute("autor", new Autor());
        return "autor/form";
    }

    @PostMapping
    public String save(@Valid Autor autor, BindingResult result, Model model, RedirectAttributes attributes) {
        if ( result.hasErrors() ) {
            model.addAttribute("autor", autor);
            return "autor/form";
        }

        autorService.save(autor);
        attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
        return "redirect:/autor";
    }

    @GetMapping("{id}")
    public String form(@PathVariable Long id, Model model) {
        model.addAttribute("autor", autorService.findOne(id));
        return "autor/form";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            autorService.delete(id);
            attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro","Falha ao remover o registro!");
        }
        return "redirect:/autor";
    }

//    @Override
//    protected CrudService<Autor, Long> getService() { return autorService; }
}
