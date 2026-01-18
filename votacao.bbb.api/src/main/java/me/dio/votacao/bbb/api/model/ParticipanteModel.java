package me.dio.votacao.bbb.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "participantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParticipanteModel {
    @Id
    private String id;
    private String nome;
}
