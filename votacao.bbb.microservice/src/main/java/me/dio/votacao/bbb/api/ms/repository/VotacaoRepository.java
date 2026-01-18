package me.dio.votacao.bbb.api.ms.repository;

import me.dio.votacao.bbb.api.ms.model.VotacaoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String> {
}
