package desafio.jpa.academia.academia_digital.service.impl;

import desafio.jpa.academia.academia_digital.entity.Aluno;
import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AvaliacaoFisicaForm;
import desafio.jpa.academia.academia_digital.entity.form.AvaliacaoFisicaUpdateForm;
import desafio.jpa.academia.academia_digital.repository.AlunoRepository;
import desafio.jpa.academia.academia_digital.repository.AvaliacaoFisicaRepository;
import desafio.jpa.academia.academia_digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImp implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado! Id: " + form.getAlunoId()));

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public Optional<AvaliacaoFisica> findById(Long id) {
        return avaliacaoFisicaRepository.findById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public Optional<AvaliacaoFisica> update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return avaliacaoFisicaRepository.findById(id).map(avaliacao -> {
            avaliacao.setPeso(formUpdate.getPeso());
            avaliacao.setAltura(formUpdate.getAltura());
            return avaliacaoFisicaRepository.save(avaliacao);
        });
    }

    @Override
    public boolean delete(Long id) {
        if (avaliacaoFisicaRepository.existsById(id)) {
            avaliacaoFisicaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}