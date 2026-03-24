package desafio.jpa.academia.academia_digital.service;

import desafio.jpa.academia.academia_digital.entity.Aluno;
import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AlunoForm;
import desafio.jpa.academia.academia_digital.entity.form.AlunoUpdateForm;

import java.util.List;
import java.util.Optional;

public interface IAlunoService {

    Aluno create(AlunoForm form);

    Optional<Aluno> findById(Long id);

    List<Aluno> getAll(String dataDeNascimento);

    Optional<Aluno> update(Long id, AlunoUpdateForm formUpdate);

    boolean delete(Long id);

    List<AvaliacaoFisica> getAllAvaliacoesByAlunoId(Long id);
}
