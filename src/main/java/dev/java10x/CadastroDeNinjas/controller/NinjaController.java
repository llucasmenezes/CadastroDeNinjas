package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    NinjaService ninjaService;


    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> getAllNinjas() {
       List<NinjaDTO> ninjas = ninjaService.findAll();
       return new ResponseEntity<>(ninjas, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<NinjaDTO> saveNinja(@RequestBody NinjaDTO ninjaModel){
        NinjaDTO ninja = ninjaService.createNinja(ninjaModel);
        return new ResponseEntity<>(ninja, HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<NinjaDTO>> getNinjaById(@PathVariable  Long id){
        Optional<NinjaDTO> ninja = ninjaService.findById(id);
        if(!ninja.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       return new ResponseEntity<>(ninja, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNinja(@PathVariable Long id) {
        boolean isDeleted = ninjaService.deleteNinjaById(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 }

