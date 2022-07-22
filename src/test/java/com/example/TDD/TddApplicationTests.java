package com.example.TDD;

import com.example.armazem.Armazem;
import com.example.ingredientes.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TddApplicationTests {

    TreeMap<Ingrediente, Integer> novoEstoque = new TreeMap<>();
    Armazem estoqueArmazem = new Armazem(novoEstoque);

    @Test
    void contextLoads() {

    }

    @Test
    void test_cadastrarIngredienteEmEstoque() {
        Base novaBase = new Base(TipoBase.Sorvete);

        try {
            estoqueArmazem.cadastrarIngredienteEmEstoque(novaBase);
            estoqueArmazem.cadastrarIngredienteEmEstoque(novaBase);
        } catch
        (IllegalArgumentException e) {
            assertEquals(1, estoqueArmazem.getEstoque().size());
            assertEquals("_Ingrediente já cadastrado_", e.getMessage());
        }
    }

    @Test
    void test_descadastrarIngredienteEmEstoque() {
        Base novaBase = new Base(TipoBase.Sorvete);

        try {
            estoqueArmazem.cadastrarIngredienteEmEstoque(novaBase);
            estoqueArmazem.descadastrarIngredienteEmEstoque(novaBase);
            estoqueArmazem.descadastrarIngredienteEmEstoque(novaBase);
        } catch (IllegalArgumentException e) {
            assertEquals(0, estoqueArmazem.getEstoque().size());
            assertEquals("_Ingrediente não encontrado_", e.getMessage());
        }
    }

    @Test
    void test_adicionarQuantidadeDoIngrediente() {
        Fruta novaFruta = new Fruta(TipoFruta.Morango);
        int quantidade = 2;
        int quantidadeNova = quantidade + 5;
        int quantidadeInvalida = -12;

        try {
            estoqueArmazem.cadastrarIngredienteEmEstoque(novaFruta);

            estoqueArmazem.adicionarQuantidadeDoIngredienteEmEstoque(novaFruta, quantidade);
            assertEquals(true, estoqueArmazem.getEstoque().containsValue(quantidade));

            estoqueArmazem.adicionarQuantidadeDoIngredienteEmEstoque(novaFruta, quantidadeNova);
            assertEquals(true, estoqueArmazem.getEstoque().containsValue(quantidade + quantidadeNova));

            estoqueArmazem.adicionarQuantidadeDoIngredienteEmEstoque(novaFruta, quantidadeInvalida);
        } catch (IllegalArgumentException e) {
            assertEquals("_Ingrediente não encontrado ou quantidade inválida_", e.getMessage());
        }
    }

    @Test
    void test_reduzirQuantidadeDoIngrediente() {
        Topping novoTopping = new Topping(TipoTopping.Chocolate);
        int quantidade = 12;
        int quantidadeAReduzir = 2;

        try {
            estoqueArmazem.cadastrarIngredienteEmEstoque(novoTopping);
            estoqueArmazem.adicionarQuantidadeDoIngredienteEmEstoque(novoTopping, quantidade);

            estoqueArmazem.reduzirQuantidadeDoIngredienteEmEstoque(novoTopping, quantidadeAReduzir);
            assertEquals(true, estoqueArmazem.getEstoque().containsValue(quantidade - quantidadeAReduzir));
        } catch (IllegalArgumentException e) {
            assertEquals("_Ingrediente não encontrado ou quantidade inválida_", e.getMessage());
        }
    }
}
