package desafio.jpa.academia.academia_digital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Matricula {

    private Long id;

    private Aluno aluno;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
