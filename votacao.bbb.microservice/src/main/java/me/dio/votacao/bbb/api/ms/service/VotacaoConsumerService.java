package me.dio.votacao.bbb.api.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.dio.votacao.bbb.api.ms.model.ParticipanteModel;
import me.dio.votacao.bbb.api.ms.model.VotacaoModel;
import me.dio.votacao.bbb.api.ms.repository.VotacaoRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class VotacaoConsumerService {

    private static final Logger log = LoggerFactory.getLogger(VotacaoConsumerService.class);
    private final VotacaoRepository votacaoRepository;

    public VotacaoConsumerService(VotacaoRepository votacaoRepository) {
        this.votacaoRepository = votacaoRepository;
    }

    @KafkaListener(topics = "votacao", groupId = "MicroRegistroVotacao")
    private void executar(ConsumerRecord<String, String> registro) throws JsonProcessingException {
        try {

            String participanteValue = registro.value();

            ObjectMapper mapper = new ObjectMapper();

            ParticipanteModel participante = mapper.readValue(participanteValue, ParticipanteModel.class);

            Instant dataHoraVoto = Instant.ofEpochMilli(registro.timestamp());

            VotacaoModel votacao = this.votacaoRepository.save(new VotacaoModel(null, participante, dataHoraVoto));

            log.info(
                    "Voto registrado: [Nome: {}, UTC: {}, Brasil: {}]",
                    votacao.getParticipante().getNome(),
                    dataHoraVoto,
                    dataHoraVoto.atZone(ZoneId.of("America/Sao_Paulo"))
            );

        }catch (JsonProcessingException jpe) {
            log.info("Falha ao converter o voto!!");
        }

        catch (Exception e) {
            log.info("Erro inesperado!!");
        }
    }
}
