package desafio.jpa.academia.academia_digital.service;

import desafio.jpa.academia.academia_digital.entity.Aluno;
import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AlunoForm;
import desafio.jpa.academia.academia_digital.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {
    Aluno create(AlunoForm form);

    Aluno get(Long id);

    List<Aluno> getALl();

    Aluno update(Long id, AlunoUpdateForm formUpdate);

    void delete(Long id);


    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);
}
