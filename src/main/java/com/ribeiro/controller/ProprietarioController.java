package com.ribeiro.controller;

import com.ribeiro.domain.model.Proprietario;
import com.ribeiro.domain.repository.ProprietarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProprietarioController {

    private final ProprietarioRepository proprietarioRepository;

    @GetMapping("proprietarios")
    public List<Proprietario> listar() {
       // return proprietarioRepository.findByNomeContaining("so");
       // return proprietarioRepository.findByNome("anailson");
             return    proprietarioRepository.findAll();
    }

}
