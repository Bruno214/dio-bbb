package me.dio.votacao.bbb.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "parametros")
public class ParametroModel {
    public ParametroModel(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public ParametroModel() {
    }

    @Id
    private String chave;
    private String valor;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
