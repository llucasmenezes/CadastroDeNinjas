package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.MAPPER.MissoesMapper;
import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import dev.java10x.CadastroDeNinjas.exceptions.IdExistsException;
import dev.java10x.CadastroDeNinjas.exceptions.NoExistIdException;
import dev.java10x.CadastroDeNinjas.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MissoesService {


    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }



    public List<MissoesDTO> getAll(){
        List<MissoesModel> missoesModel = missoesRepository.findAll();
        return missoesModel.stream()
                           .map(missoesMapper::map)
                           .collect(Collectors.toList());
    }


    public MissoesDTO createMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        if(!missoesRepository.existsById(missoesDTO.getId())){
            throw new IdExistsException("missao ja Existente");
        }

        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }



    public Optional<MissoesDTO> findById(Long id) {
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        if(!missoes.isPresent()){
            throw new NoExistIdException(id);
        }
        return missoes.map(missoesMapper::map);

    }


    public MissoesDTO missoesDTO(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(!missaoExistente.isPresent()){
            throw  new NoExistIdException(id);
        }

        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel.setId(id);
        MissoesModel missaoSave = missoesRepository.save(missoesModel);
        return missoesMapper.map(missaoSave);
    }


    public void deleteMissaoById(Long id){
        if(!missoesRepository.existsById(id)){
            throw new NoExistIdException(id);
        }
         missoesRepository.deleteById(id);
    }
}
