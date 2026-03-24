package desafio.jpa.academia.academia_digital.repository;

import desafio.jpa.academia.academia_digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

    boolean existsByCpf(String cpf);
}
