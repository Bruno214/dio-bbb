package me.dio.votacao.bbb.api.repository;

import me.dio.votacao.bbb.api.model.ParticipanteModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {
}
