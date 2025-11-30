package com.ribeiro.assembler;

import com.ribeiro.domain.model.Veiculo;
import com.ribeiro.domain.model.input.VeiculoInput;
import com.ribeiro.model.VeiculoModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {

    private final ModelMapper modelMapper;

    public Veiculo toEntity(VeiculoInput veiculoInput) {
        return modelMapper.map(veiculoInput, Veiculo.class);
    }

    public VeiculoModel toModel(Veiculo veiculo) {
        return modelMapper.map(veiculo, VeiculoModel.class);
    }

    public List<VeiculoModel> toCollectionModel(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(this::toModel)
                .toList();
    }
}
