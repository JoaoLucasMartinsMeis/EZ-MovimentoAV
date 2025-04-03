package com.senai.avaliacao030425.services;

import com.senai.avaliacao030425.dtos.MovimentoDTO;
import com.senai.avaliacao030425.models.Movimento;
import com.senai.avaliacao030425.repositories.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepository;

    public MovimentoDTO saveMovimento(MovimentoDTO movimentoDTO) {
        Movimento movimento = convertMovimentoDTOToMovimento(movimentoDTO);
        movimento = movimentoRepository.save(movimento);
        return convertMovimentoToMovimentoDTO(movimento);
    }

    public Movimento getMovimentoById(Long id) {
        return movimentoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Movimento not found"));
    }

    public MovimentoDTO updateMovimento(MovimentoDTO movimentoDTO) {
        if (isNull(movimentoDTO.getId())) {
            throw new IllegalArgumentException("Id can't be null");
        }

        Movimento movimento = movimentoRepository.findById(movimentoDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Movimento not found"));

        movimento = convertMovimentoDTOToMovimento(movimentoDTO);
        movimento = movimentoRepository.save(movimento);
        return convertMovimentoToMovimentoDTO(movimento);
    }

    public void deleteMovimento(Long id) {
        movimentoRepository.deleteById(id);
    }

    public MovimentoDTO convertMovimentoToMovimentoDTO(Movimento movimento) {
        MovimentoDTO movimentoDTO = new MovimentoDTO();
        movimentoDTO.setId(movimento.getId());
        movimentoDTO.setData_movimento(movimento.getData_movimento());
        movimentoDTO.setValor(movimento.getValor());
        movimentoDTO.setObservacao(movimento.getObservacao());
        movimentoDTO.setClassificacao(movimento.getClassificacao());
        return movimentoDTO;
    }

    public Movimento convertMovimentoDTOToMovimento(MovimentoDTO movimentoDTO) {
        Movimento movimento = new Movimento();
        movimento.setId(movimentoDTO.getId());
        movimento.setData_movimento(movimentoDTO.getData_movimento());
        movimento.setValor(movimentoDTO.getValor());
        movimento.setObservacao(movimentoDTO.getObservacao());
        movimento.setClassificacao(movimentoDTO.getClassificacao());
        return movimento;
    }
}
