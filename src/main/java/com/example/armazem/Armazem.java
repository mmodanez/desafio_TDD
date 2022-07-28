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

    private Integer getIngrediente(Ingrediente ingrediente) {
        return estoque.get(ingrediente);
    }

    private boolean isContainsKey(Ingrediente ingrediente) {
        return estoque.containsKey(ingrediente);
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (isContainsKey(ingrediente))
            throw new IllegalArgumentException("_Ingrediente já cadastrado_");
        else
            estoque.put(ingrediente, 0);
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (isContainsKey(ingrediente))
            estoque.remove(ingrediente);
        else
            throw new IllegalArgumentException("_Ingrediente não encontrado_");
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        if (isContainsKey(ingrediente) && quantidade > 0) {
            int quantidadeNova = getIngrediente(ingrediente) + quantidade;
            estoque.put(ingrediente, quantidadeNova);
        } else
            throw new IllegalArgumentException("_Ingrediente não encontrado ou quantidade inválida_");
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        if (isContainsKey(ingrediente)) {
            if (getIngrediente(ingrediente) >= quantidade && quantidade > 0) {
                int quantidadeNova = getIngrediente(ingrediente) - quantidade;
                estoque.put(ingrediente, quantidadeNova);
            }
        } else
            throw new IllegalArgumentException("_Ingrediente não encontrado ou quantidade inválida_");
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {
        int quantidade = 0;

        if (isContainsKey(ingrediente))
            quantidade = getIngrediente(ingrediente);

        return quantidade;
    }

}
