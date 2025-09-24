package io.github.cursodsousa.produtosapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.cursodsousa.produtosapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

	List<Produto> findByNomeContaining(String nome);

}
