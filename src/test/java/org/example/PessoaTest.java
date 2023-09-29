package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class PessoaTest {

    @Test
    public void testPessoaValida() {
        Pessoa pessoa = new Pessoa(1, "Thalia");
        assertTrue(pessoa.valido());
    }

    @Test
    public void testPessoaInvalida() {
        Pessoa pessoa = new Pessoa();
        assertFalse(pessoa.valido());
    }

    @Test
    public void testPessoaNomeVazio() {
        Pessoa pessoa = new Pessoa(2, "");
        assertFalse(pessoa.valido());
    }

    @Test
    public void testPessoaIdNegativo() {
        Pessoa pessoa = new Pessoa(-1, "Carol");
        assertFalse(pessoa.valido());
    }
}
