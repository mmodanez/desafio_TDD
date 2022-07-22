package com.example.armazem;

import com.example.ingredientes.Ingrediente;

import java.util.TreeMap;

public class Armazem {

    private TreeMap<Ingrediente, Integer> estoque = new TreeMap<>();

    public Armazem(TreeMap<Ingrediente, Integer> estoque) {
        this.estoque = estoque;
    }

    public TreeMap<Ingrediente, Integer> getEstoque() {
        return estoque;
    }

    public void setEstoque(TreeMap<Ingrediente, Integer> estoque) {
        this.estoque = estoque;
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (estoque.containsKey(ingrediente)) {
            throw new IllegalArgumentException("_Ingrediente já cadastrado_");
        } else {
            estoque.put(ingrediente, 0);
        }
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (estoque.containsKey(ingrediente)) {
            estoque.remove(ingrediente);
        } else {
            throw new IllegalArgumentException("_Ingrediente não encontrado_");
        }
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        if (estoque.containsKey(ingrediente) && quantidade > 0) {
            int quantidadeNova = estoque.get(ingrediente) + quantidade;
            estoque.put(ingrediente, quantidadeNova);
        } else {
            throw new IllegalArgumentException("_Ingrediente não encontrado ou quantidade inválida_");
        }
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        if (estoque.containsKey(ingrediente)) {
            if (estoque.get(ingrediente) >= quantidade && quantidade > 0) {
                int quantidadeNova = estoque.get(ingrediente) - quantidade;
                estoque.put(ingrediente, quantidadeNova);
            }
        } else {
            throw new IllegalArgumentException("_Ingrediente não encontrado ou quantidade inválida_");
        }
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {
        int quantidade = 0;

        if (estoque.containsKey(ingrediente)) {
            quantidade = estoque.get(ingrediente);
        }

        return quantidade;
    }


}
