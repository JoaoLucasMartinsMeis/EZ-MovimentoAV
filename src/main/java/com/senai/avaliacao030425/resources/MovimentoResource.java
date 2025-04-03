package com.senai.avaliacao030425.resources;

import com.senai.avaliacao030425.dtos.MovimentoDTO;
import com.senai.avaliacao030425.models.Movimento;
import com.senai.avaliacao030425.services.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimento")
public class MovimentoResource {

    @Autowired
    private MovimentoService movimentoService;

    @GetMapping("{id}")
    public ResponseEntity<MovimentoDTO> getMovimentobyId(@PathVariable Long id) {
        Movimento movimento = movimentoService.getMovimentoById(id);
        return ResponseEntity.ok(movimentoService.convertMovimentoToMovimentoDTO(movimento));
    }

    @PostMapping("")
    public ResponseEntity<MovimentoDTO> createMovimento(@RequestBody MovimentoDTO movimentoDTO) {
        return ResponseEntity.ok(movimentoService.saveMovimento(movimentoDTO));
    }

    @PutMapping()
    public ResponseEntity<MovimentoDTO> updateMovimento(@RequestBody MovimentoDTO movimentoDTO) {
        return ResponseEntity.ok(movimentoService.updateMovimento(movimentoDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteMovimento(@RequestBody MovimentoDTO movimentoDTO) {
        movimentoService.deleteMovimento(movimentoDTO.getId());
        return ResponseEntity.noContent().build();
    }
}

