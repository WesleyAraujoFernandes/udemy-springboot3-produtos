package io.github.cursodsousa.produtosapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.cursodsousa.produtosapi.model.Produto;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto p = produtoExistente.get();
            p.setNome(produto.getNome());
            p.setDescricao(produto.getDescricao());
            p.setPreco(produto.getPreco());
            produtoRepository.save(p);
            return p;
        } else {
            throw new RuntimeException("Produto não encontrado com id: " + id);
        }
    }

    public List<Produto> buscar(@RequestParam(value = "nome", required = false) String nome) {
        if (nome != null) {
            return produtoRepository.findByNomeContaining(nome);
        }
        return produtoRepository.findAll();
    }
}
