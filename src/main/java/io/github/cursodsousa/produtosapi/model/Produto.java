package io.github.cursodsousa.produtosapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
}
