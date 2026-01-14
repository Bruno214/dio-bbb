package me.dio.coding.votacao.bbb.api.controller;

import me.dio.coding.votacao.bbb.api.model.ParametroModel;
import me.dio.coding.votacao.bbb.api.repository.ParametroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

    private final ParametroRepository parametroRepository;

    public ParametroController(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametroModel) {
        ParametroModel entidade = this.parametroRepository.save(parametroModel);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParametroModel> consultar(@RequestParam ("chave") String chave) {
        Optional<ParametroModel> optionalEntidade = this.parametroRepository.findById(chave);
        return optionalEntidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
