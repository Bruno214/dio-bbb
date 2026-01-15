package me.dio.votacao.bbb.api.repository;

import me.dio.votacao.bbb.api.model.ParametroModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends MongoRepository<ParametroModel, String> {
}
