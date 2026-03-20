package desafio.jpa.academia.academia_digital.service;


import desafio.jpa.academia.academia_digital.entity.Matricula;
import desafio.jpa.academia.academia_digital.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {

    Matricula create(MatriculaForm form);

    Matricula get(Long id);

    List<Matricula> getALl();

    void delete(Long id);
}
