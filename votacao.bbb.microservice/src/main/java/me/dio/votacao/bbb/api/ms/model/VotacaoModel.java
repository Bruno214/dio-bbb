package me.dio.votacao.bbb.api.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Document("votacao")
public class VotacaoModel {

    public VotacaoModel(String id, ParticipanteModel participante, Instant dataHora) {
        this.id = id;
        this.participante = participante;
        this.dataHora = dataHora;
    }

    public VotacaoModel() {
    }

    @Id
    private String id;
    private ParticipanteModel participante;
    private Instant dataHora;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParticipanteModel getParticipante() {
        return participante;
    }

    public void setParticipante(ParticipanteModel participante) {
        this.participante = participante;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }
}
