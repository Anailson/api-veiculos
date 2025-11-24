package com.ribeiro.controller;


import com.ribeiro.domain.exception.NegocioException;
import com.ribeiro.domain.model.Veiculo;
import com.ribeiro.domain.repository.VeiculoRepository;
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

    @GetMapping
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculo -> {
                    var veiculoModel = new VeiculoModel();
                    veiculoModel.setId(veiculo.getId());
                    veiculoModel.setNomeProprietario(veiculo.getProprietario().getNome());
                    veiculoModel.setMarca(veiculo.getMarca());
                    veiculoModel.setModelo(veiculo.getModelo());
                    veiculoModel.setNumeroPlaca(veiculo.getPlaca());
                    veiculoModel.setStatus(veiculo.getStatus());
                    veiculoModel.setDataApreensao(veiculo.getDataApreensao());
                    return  veiculoModel;
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return registroVeiculoService.cadastrar(veiculo);

    }


}
