package me.dio.votacao.bbb.api.services;

import me.dio.votacao.bbb.api.model.ParticipanteModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VotacaoService {

    private static String TOPIC_VOTACAO = "votacao";
    private final KafkaTemplate<String, ParticipanteModel> kafkaTemplate;

    public VotacaoService(KafkaTemplate<String, ParticipanteModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void adicionarEvento(ParticipanteModel participante){

        this.kafkaTemplate.send(TOPIC_VOTACAO, participante);
    }

}
