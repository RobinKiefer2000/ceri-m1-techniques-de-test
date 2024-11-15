package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals(613, bulbizarre.getCp());
        assertEquals(64, bulbizarre.getHp());
        assertEquals(4000, bulbizarre.getDust());
        assertEquals(4, bulbizarre.getCandy());

        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(133, aquali.getIndex());
        assertEquals(2729, aquali.getCp());
        assertEquals(202, aquali.getHp());
        assertEquals(5000, aquali.getDust());
        assertEquals(4, aquali.getCandy());
    }
}
