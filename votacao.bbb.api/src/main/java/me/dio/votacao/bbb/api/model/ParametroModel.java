package me.dio.votacao.bbb.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parametros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParametroModel {

    @Id
    private String chave;
    private ConfigVotacao configVotacao;
}
