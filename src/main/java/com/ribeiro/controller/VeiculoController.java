package com.ribeiro.controller;

import com.ribeiro.assembler.VeiculoAssembler;
import com.ribeiro.domain.model.Veiculo;
import com.ribeiro.domain.model.input.VeiculoInput;
import com.ribeiro.domain.repository.VeiculoRepository;
import com.ribeiro.domain.service.ApreensaoVeiculoService;
import com.ribeiro.domain.service.RegistroVeiculoService;
import com.ribeiro.model.VeiculoModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;
    private final VeiculoAssembler veiculoAssembler;
    private final ApreensaoVeiculoService apreensaoVeiculoService;

    @GetMapping
    public List<VeiculoModel> listar() {
        return veiculoAssembler.toCollectionModel(veiculoRepository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoModel cadastrar(@Valid @RequestBody VeiculoInput veiculoInput) {
        Veiculo novoVeiculo = veiculoAssembler.toEntity(veiculoInput);
        Veiculo veiculoCadastrado = registroVeiculoService.cadastrar(novoVeiculo);

        return veiculoAssembler.toModel(veiculoCadastrado);

    }

    @PutMapping("/{veiculoId}/apreensao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apreender(@PathVariable Long veiculoId) {
        apreensaoVeiculoService.apreender(veiculoId);
    }

    @DeleteMapping("/{veiculoId}/apreensao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerApreensao(@PathVariable Long veiculoId) {
        apreensaoVeiculoService.removerApreensao(veiculoId);
    }

}
