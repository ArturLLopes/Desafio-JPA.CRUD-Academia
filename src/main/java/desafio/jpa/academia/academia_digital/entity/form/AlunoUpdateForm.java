package desafio.jpa.academia.academia_digital.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AlunoUpdateForm {

    private  String nome;

    private  String bairro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNacimento;
}
