package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.entities.MissoesModel;
import dev.java10x.CadastroDeNinjas.repository.MissoesRepository;
import dev.java10x.CadastroDeNinjas.service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

MissoesService missoesService;
MissoesRepository missoesRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesModel>> getAllMission() {
    List<MissoesModel> missoes  = missoesService.getAll();
    return new ResponseEntity<>(missoes, HttpStatus.OK);
}

    @GetMapping("missao")
    public ResponseEntity<MissoesModel> getMissionById(@PathVariable Long id){
        Optional<MissoesModel> missao = Optional.ofNullable(missoesService.findById(id));
        if(missao.isPresent()){
            return ResponseEntity.ok(missao.get());
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping("salvar")
    public ResponseEntity<MissoesModel> saveMission(@RequestBody MissoesModel missoesModel){
        MissoesModel savedMissao = missoesService.saveMissao(missoesModel);
        return new ResponseEntity<>(savedMissao, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMissao(@PathVariable  Long id){

        if(missoesRepository.existsById(id)){
            missoesService.deleteMissaoById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
