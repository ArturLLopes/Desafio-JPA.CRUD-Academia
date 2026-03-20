package desafio.jpa.academia.academia_digital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private Long id;

    private  String nome;

    private String cpf;

    private String bairro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private List<AvaliacaoFisica> avaliacao = new ArrayList<>();
}
