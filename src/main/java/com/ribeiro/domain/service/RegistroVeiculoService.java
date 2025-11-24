package com.ribeiro.domain.service;

import com.ribeiro.domain.exception.NegocioException;
import com.ribeiro.domain.model.Proprietario;
import com.ribeiro.domain.model.StatusVeiculo;
import com.ribeiro.domain.model.Veiculo;
import com.ribeiro.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {

        if (novoVeiculo.getId() != null) {
            throw new NegocioException("Veiculo a ser cadastraro n]ao deve possuir um id");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo -> !veiculo.equals(novoVeiculo))
                .isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veículo cadastrado com esta placa");
        }

        Proprietario proprietario = registroProprietarioService.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(OffsetDateTime.now());

        return veiculoRepository.save(novoVeiculo);
    }


}
