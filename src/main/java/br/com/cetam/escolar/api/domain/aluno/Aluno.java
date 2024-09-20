package br.com.cetam.escolar.api.domain.aluno;

import br.com.cetam.escolar.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
@Data
@Table(name = "alunos")
@Entity(name = "Aluno")
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String rg;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Aluno (){}

    public Aluno (DadosCadastroAluno dados){
        this.ativo = true;
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

}
