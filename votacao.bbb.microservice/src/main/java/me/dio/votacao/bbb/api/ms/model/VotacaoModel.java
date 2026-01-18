package me.dio.votacao.bbb.api.ms.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("votacao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VotacaoModel {

    @Id
    private String id;
    private ParticipanteModel participante;
    private Instant dataHora;
}
