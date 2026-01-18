package me.dio.votacao.bbb.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConfigVotacao {

    private List<ParticipanteModel> participantes;
    private Integer quantidadeParticipantes;
    private Boolean ativa;
}