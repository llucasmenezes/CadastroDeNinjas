package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.MAPPER.NinjaMapper;
import dev.java10x.CadastroDeNinjas.entities.NinjaModel;
import dev.java10x.CadastroDeNinjas.exceptions.IdExistsException;
import dev.java10x.CadastroDeNinjas.exceptions.NoExistIdException;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class NinjaService {

    @Autowired
    NinjaRepository repository;

    @Autowired
    private final NinjaMapper ninjaMapper;



    public List<NinjaDTO> findAll() {
       List<NinjaModel> ninjaModel = repository.findAll();
        return ninjaModel.stream()
                         .map(ninjaMapper::map)
                         .collect(Collectors.toList());
    }


    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        if(!repository.existsById(ninjaDTO.getId())) {
            throw new IdExistsException("Ops... Ninja já existente!");
        }

        ninjaModel = repository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }


    public Optional<NinjaDTO> findById(Long id){
        Optional<NinjaModel> ninjaPorId = repository.findById(id);
        if(!ninjaPorId.isPresent()){
            throw new NoExistIdException(id);
        }
        return ninjaPorId.map(ninjaMapper::map);
    }

    public NinjaDTO NinjaUpdate(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaModel = repository.findById(id);
        if(!ninjaModel.isPresent()){
            throw new NoExistIdException(id);
        }
        NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
        ninjaUpdated.setId(id);
        NinjaModel ninjaSave = repository.save(ninjaUpdated);
        return ninjaMapper.map(ninjaSave);
    }

    public boolean deleteNinjaById(Long id) {
            if(!repository.existsById(id)){
              throw new NoExistIdException(id);
            }
            repository.deleteById(id);
                    return false;
   }

}






















