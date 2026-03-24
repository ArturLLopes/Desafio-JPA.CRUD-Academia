package desafio.jpa.academia.academia_digital.controller;


import desafio.jpa.academia.academia_digital.entity.Aluno;
import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AlunoForm;
import desafio.jpa.academia.academia_digital.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id){
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        return service.getAll(dataDeNascimento);
    }

}
