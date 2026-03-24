package desafio.jpa.academia.academia_digital.entity.form;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import desafio.jpa.academia.academia_digital.infra.ser.CustomLocalDateDeserializer;

import java.time.LocalDate;

public class AlunoUpdateForm {

    private  String nome;

    private  String bairro;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate dataDeNacimento;
}
