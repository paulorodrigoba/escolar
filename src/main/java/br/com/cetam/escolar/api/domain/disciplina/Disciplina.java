package br.com.cetam.escolar.api.domain.disciplina;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "disciplinas")
public class Disciplina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String nome;

    private String area;

    private Integer cargaHoraria;

    public Disciplina(){

    }
    public Disciplina(DadosCadastroDisciplina dados){
        this.codigo = dados.codigo();
        this.nome = dados.nome();
        this.area = dados.area();
        this.cargaHoraria = dados.cargaHoraria();
    }

}
