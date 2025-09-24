package io.github.cursodsousa.produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cursodsousa.produtosapi.model.Produto;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto salvo: " + produto);
        return produto;
    }
}
