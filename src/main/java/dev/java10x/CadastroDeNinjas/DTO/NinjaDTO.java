package dev.java10x.CadastroDeNinjas.DTO;

import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;

    private String name;

    private String email;

    private String imgUrl;

    private String age;

    private String rank;

    private MissoesModel missoes;
}
