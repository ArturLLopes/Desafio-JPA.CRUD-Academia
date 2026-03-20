package desafio.jpa.academia.academia_digital.service;

import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AvaliacaoFisicaForm;
import desafio.jpa.academia.academia_digital.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaForm form);

    AvaliacaoFisica get(Long id);

    List<AvaliacaoFisica> getAll();

    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

    void delete(Long id);
}
