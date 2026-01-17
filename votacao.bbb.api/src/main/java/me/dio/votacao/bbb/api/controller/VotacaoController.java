package me.dio.votacao.bbb.api.controller;

import me.dio.votacao.bbb.api.model.ParticipanteModel;
import me.dio.votacao.bbb.api.services.VotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/votacao")
public class VotacaoController {

    private final VotacaoService votacaoService;


    public VotacaoController(VotacaoService votacaoService) {
        this.votacaoService = votacaoService;
    }

    @PostMapping("/votar")
    public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante) {
        this.votacaoService.adicionarEvento(participante);

        return ResponseEntity.ok("Voto computado");
    }
}
