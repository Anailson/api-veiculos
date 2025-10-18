package com.ribeiro.controller;

import com.ribeiro.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("proprietarios")
    public List<Proprietario> listar() {
        var proprietario1 = new Proprietario();
        proprietario1.setId(1L);
        proprietario1.setNome("Teste");
        proprietario1.setEmail("teste@gmail.com");
        proprietario1.setTelefone("46464464");

        var proprietario2 = new Proprietario();
        proprietario2.setId(2L);
        proprietario2.setNome("Teste");
        proprietario2.setEmail("teste@gmail.com");
        proprietario2.setTelefone("46464464");

       return Arrays.asList(proprietario1, proprietario2);

    }

}
