package desafio.jpa.academia.academia_digital.service;

import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AvaliacaoFisicaForm;
import desafio.jpa.academia.academia_digital.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;
import java.util.Optional;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaForm form);

    Optional<AvaliacaoFisica> findById(Long id);

    List<AvaliacaoFisica> getAll();

    Optional<AvaliacaoFisica> update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

    boolean delete(Long id);
}