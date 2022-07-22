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


}
