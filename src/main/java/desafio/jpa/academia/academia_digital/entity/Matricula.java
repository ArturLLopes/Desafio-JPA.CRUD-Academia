package desafio.jpa.academia.academia_digital.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import desafio.jpa.academia.academia_digital.infra.ser.CustomLocalDateDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
