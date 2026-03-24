package desafio.jpa.academia.academia_digital.service.impl;

import desafio.jpa.academia.academia_digital.entity.Aluno;
import desafio.jpa.academia.academia_digital.entity.Matricula;
import desafio.jpa.academia.academia_digital.entity.form.MatriculaForm;
import desafio.jpa.academia.academia_digital.repository.AlunoRepository;
import desafio.jpa.academia.academia_digital.repository.MatriculaRepository;
import desafio.jpa.academia.academia_digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        if (matriculaRepository.existsByAlunoId(form.getAlunoId())) {
            throw new RuntimeException("Aluno já possui matrícula ativa!");
        }

        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado! Id: " + form.getAlunoId()));

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Optional<Matricula> findById(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return matriculaRepository.findAll();
        }
        return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

    @Override
    public boolean delete(Long id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}