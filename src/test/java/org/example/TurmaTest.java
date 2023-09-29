package org.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TurmaTest extends TestCase {
    private Turma turma;
    @Before
    public void setUp() {
        turma = new Turma();
    }
    @Test
    public void testAdicionarPessoaValida() {
        Pessoa pessoa = new Pessoa(1, "Thalia");

        try {
            turma.adicionarPessoa(pessoa);

            assertEquals(1, turma.getPessoas().size());
            assertEquals(pessoa, turma.getPessoas().get(0));
        } catch (Exception e) {
            fail("Exceção não esperada: " + e.getMessage());
        }
    }
    @Test
    public void testAdicionarPessoaInvalida() {
        Pessoa pessoa = new Pessoa();

        try {
            turma.adicionarPessoa(pessoa);
            fail("Exceção esperada ao adicionar pessoa inválida, mas não foi lançada.");
        } catch (Exception e) {
            assertEquals("Objeto pessoa inválido", e.getMessage());
        }
    }

    public void testAdicionarPessoaRepetida() {
        Pessoa pessoa1 = new Pessoa(1, "Thalia");
        Pessoa pessoa2 = new Pessoa(1, "Ana");

        try {
            turma.adicionarPessoa(pessoa1);
            turma.adicionarPessoa(pessoa2);

            fail("Exceção esperada ao adicionar pessoa duplicada, mas não foi lançada.");
        } catch (Exception e) {
            assertEquals("Objeto pessoa já está atribuido a turma", e.getMessage());
        }
    }
    @Test
    public void testRemoverTodos() throws Exception {
        Pessoa pessoa1 = new Pessoa(1, "Thalia");
        Pessoa pessoa2 = new Pessoa(2, "Carol");

        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        turma.removerTodasPessoas();

        ArrayList<Pessoa> pessoasNaTurma = turma.getPessoas();
        assertTrue(pessoasNaTurma.isEmpty());
    }
}