package desafio.jpa.academia.academia_digital.service;

import desafio.jpa.academia.academia_digital.entity.Matricula;
import desafio.jpa.academia.academia_digital.entity.form.MatriculaForm;

import java.util.List;
import java.util.Optional;

public interface IMatriculaService {

    Matricula create(MatriculaForm form);

    Optional<Matricula> findById(Long id);

    List<Matricula> getAll(String bairro);

    boolean delete(Long id);
}