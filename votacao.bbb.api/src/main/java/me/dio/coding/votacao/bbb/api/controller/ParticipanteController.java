package me.dio.coding.votacao.bbb.api.controller;

import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteController(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParticipanteModel> consultar(@RequestParam("id") String id) {
        Optional<ParticipanteModel> optionalParticipante = this.participanteRepository.findById(id);
        return optionalParticipante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> consultar(@RequestBody ParticipanteModel participanteModel) {
        ParticipanteModel participante = this.participanteRepository.save(participanteModel);
        return ResponseEntity.ok(participante);
    }
}