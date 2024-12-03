package dev.java10x.CadastroDeNinjas.MAPPER;

import dev.java10x.CadastroDeNinjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.entities.NinjaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface NinjaMapper {

     NinjaModel map(NinjaDTO ninjaDTO);
     NinjaDTO map(NinjaModel ninjaModel);

}
