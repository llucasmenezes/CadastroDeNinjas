package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import dev.java10x.CadastroDeNinjas.entities.NinjaModel;
import dev.java10x.CadastroDeNinjas.repository.MissoesRepository;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    NinjaRepository repository;

    @Autowired
    private MissoesRepository missoesRepository;

    public NinjaModel createNinja(NinjaModel ninjaModel) {
        // Salvar a missão se ela ainda não estiver salva
        if (ninjaModel.getMissoes() != null && ninjaModel.getMissoes().getId() == null) {
            MissoesModel savedMissao = missoesRepository.save(ninjaModel.getMissoes());
            ninjaModel.setMissoes(savedMissao); // Atualiza a missão com a entidade salva
        }
        return repository.save(ninjaModel); // Salva o ninja no banco de dados
    }

    public NinjaModel findById(Long id){
        Optional<NinjaModel> ninjaPorId = repository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public List<NinjaModel> findAll() {
        return repository.findAll();
    }

    public boolean deleteNinjaById(Long id) {
        repository.deleteById(id);
        return false;
   }

}






















