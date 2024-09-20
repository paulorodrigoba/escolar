package br.com.cetam.escolar.api.domain.professor;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "professores")
public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;

    private String telefone;

    private LocalDate admissao;
    private int cargaHoraria;
    private Boolean ativo;

    public Professor(){}

    public Professor (DadosCadastroProfessor dados){
        this.ativo = true;
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
        this.telefone = dados.telefone();
        this.admissao = dados.admissao();
        this.cargaHoraria = dados.cargaHoraria();
    }
}
