package dev.java10x.CadastroDeNinjas.MAPPER;

import dev.java10x.CadastroDeNinjas.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

public MissoesModel map(MissoesDTO missoesDTO){
    MissoesModel missoesModel = new MissoesModel();
    missoesModel.setId(missoesDTO.getId());
    missoesModel.setNome(missoesDTO.getNome());
    missoesModel.setNinjas(missoesDTO.getNinjas());
    missoesModel.setDificuldade(missoesDTO.getDificuldade());
    return missoesModel;
}

public MissoesDTO map(MissoesModel missoesModel){
    MissoesDTO missoesDTO = new MissoesDTO();
    missoesDTO.setId(missoesModel.getId());
    missoesDTO.setNome(missoesModel.getNome());
    missoesDTO.setNinjas(missoesModel.getNinjas());
    missoesDTO.setDificuldade(missoesModel.getDificuldade());
    return missoesDTO;
}
}
