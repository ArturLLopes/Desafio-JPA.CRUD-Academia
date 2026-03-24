package desafio.jpa.academia.academia_digital.service.impl;

import desafio.jpa.academia.academia_digital.entity.Aluno;
import desafio.jpa.academia.academia_digital.entity.AvaliacaoFisica;
import desafio.jpa.academia.academia_digital.entity.form.AlunoForm;
import desafio.jpa.academia.academia_digital.entity.form.AlunoUpdateForm;
import desafio.jpa.academia.academia_digital.repository.AlunoRepository;
import desafio.jpa.academia.academia_digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {

        if (repository.existsByCpf(form.getCpf())) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Optional<Aluno> findById(Long id) {

        return repository.findById(id);
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return repository.findAll();
        }
        LocalDate localDate = LocalDate.parse(dataDeNascimento);
        return repository.findByDataDeNascimento(localDate);
    }

    @Override
    public Optional<Aluno> update(Long id, AlunoUpdateForm formUpdate) {

        return repository.findById(id).map(aluno -> {
            aluno.setNome(formUpdate.getNome());
            aluno.setBairro(formUpdate.getBairro());
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
            return repository.save(aluno);
        });
    }

    @Override
    public boolean delete(Long id) {
        // ✅ Retorna boolean para o controller saber se encontrou o registro
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacoesByAlunoId(Long id) {

        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado! Id: " + id));
        return aluno.getAvaliacoes();
    }
}