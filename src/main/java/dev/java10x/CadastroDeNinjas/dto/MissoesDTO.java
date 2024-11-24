package dev.java10x.CadastroDeNinjas.DTO;

import dev.java10x.CadastroDeNinjas.entities.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;

    private String nome;

    private String dificuldade;

    private List<NinjaModel> ninjas;

}
