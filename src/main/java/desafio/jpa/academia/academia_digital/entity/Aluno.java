package desafio.jpa.academia.academia_digital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String bairro;

    @JsonFormat(pattern = "MM/dd/yyyy")  // ✅ substituído @JsonDeserialize
    private LocalDate dataDeNascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
}