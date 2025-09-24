package io.github.cursodsousa.produtosapi.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id; // Identificador único universal. Se der problema, usar String
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "descricao", length = 300)
    private String descricao;
    @Column(name = "preco")
    private Double preco;
}
