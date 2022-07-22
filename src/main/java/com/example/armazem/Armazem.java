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
}
