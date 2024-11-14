package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.entities.NinjaModel;
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

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }


    @GetMapping("/listar")
    public ResponseEntity<List<NinjaModel>> getAllNinjas() {
       List<NinjaModel> ninjas = ninjaService.findAll();
       return new ResponseEntity<>(ninjas, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<NinjaModel> saveNinja(@RequestBody NinjaModel ninjaModel){
        NinjaModel ninja = ninjaService.createNinja(ninjaModel);
        return new ResponseEntity<>(ninja, HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaModel> getNinjaById(@PathVariable  Long id){
        NinjaModel ninja = ninjaService.findById(id);
        if(ninja.getId() == null){
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

