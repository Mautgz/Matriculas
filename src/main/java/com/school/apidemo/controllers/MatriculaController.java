package com.school.apidemo.controllers;
import java.util.Optional;

import com.school.apidemo.models.Matricula;
import com.school.apidemo.repositories.MatriculaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/matricula", produces ="application/json")
public class MatriculaController {
    private final MatriculaRepository matriculaData;
    public MatriculaController(MatriculaRepository matriculaData){
        this.matriculaData = matriculaData;
        
    }
    @PostMapping(value = "/", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Matricula m){
        matriculaData.save(m);
        matriculaData.flush(); 
        Matricula generada = m;
        return new ResponseEntity<Integer>(m.getId(), HttpStatus.CREATED);
        
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Matricula> findByNumber(@PathVariable Integer id)
   {
       Optional<Matricula> optionMatricula = matriculaData.findById(id)
;
       if(optionMatricula.isPresent()) {
           Matricula matricula = optionMatricula.get();
           return new ResponseEntity<Matricula>(matricula, HttpStatus.OK);
       }else{
           return new ResponseEntity<Matricula>(HttpStatus.NOT_FOUND);
       }

    }
}
