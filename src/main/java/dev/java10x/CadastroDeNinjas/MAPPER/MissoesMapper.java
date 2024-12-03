package dev.java10x.CadastroDeNinjas.MAPPER;

import dev.java10x.CadastroDeNinjas.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring" )
public interface MissoesMapper {

  MissoesModel map(MissoesDTO missoesDTO);

  MissoesDTO map(MissoesModel missoesModel);

}
