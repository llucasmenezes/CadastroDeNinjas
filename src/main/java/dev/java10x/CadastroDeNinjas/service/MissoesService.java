package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import dev.java10x.CadastroDeNinjas.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;


    public List<MissoesModel> getAll(){
        return missoesRepository.findAll();
    }

    public MissoesModel findById(Long id) {
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        return missoes.orElseThrow(() -> new RuntimeException("Missão não encontrada!"));
    }

    public MissoesModel saveMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public void deleteMissaoById(Long id){
         missoesRepository.deleteById(id);
    }
}
