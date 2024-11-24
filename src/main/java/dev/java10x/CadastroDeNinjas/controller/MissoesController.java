package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.DTO.MissoesDTO;
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


    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> getAllMission() {
    List<MissoesDTO> missoes  = missoesService.getAll();
    return new ResponseEntity<>(missoes, HttpStatus.OK);
}

    @GetMapping("missao")
    public ResponseEntity<MissoesDTO> getMissionById(@PathVariable Long id){
        Optional<MissoesDTO> missoesDTO = missoesService.findById(id);
        if(missoesDTO.isPresent()){
            return ResponseEntity.ok(missoesDTO.get());
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping("salvar")
    public ResponseEntity<MissoesDTO> saveMission(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO savedMissao = missoesService.createMissao(missoesDTO);
        return new ResponseEntity<>(savedMissao, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMissao(@PathVariable  Long id) {
        if (missoesService.findById(id).isPresent()) {
            missoesService.deleteMissaoById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }
}
