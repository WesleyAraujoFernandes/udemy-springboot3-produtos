package io.github.cursodsousa.produtosapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cursodsousa.produtosapi.model.Produto;
import lombok.ToString;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    public void salvar(Produto produto) {
        System.out.println("Produto salvo: " + produto);
    }
}
