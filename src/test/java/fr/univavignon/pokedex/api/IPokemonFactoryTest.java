package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {

        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {

        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);

        Pokemon createdBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertEquals(0, createdBulbizarre.getIndex());
        assertEquals("Bulbizarre", createdBulbizarre.getName());
        assertEquals(613, createdBulbizarre.getCp());
        assertEquals(64, createdBulbizarre.getHp());
        assertEquals(4000, createdBulbizarre.getDust());
        assertEquals(4, createdBulbizarre.getCandy());
        assertEquals(126, createdBulbizarre.getAttack());
        assertEquals(126, createdBulbizarre.getDefense());
        assertEquals(90, createdBulbizarre.getStamina());
        assertEquals(56.0, createdBulbizarre.getIv(), 0.1);


        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        Pokemon createdAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertEquals(133, createdAquali.getIndex());
        assertEquals("Aquali", createdAquali.getName());
        assertEquals(2729, createdAquali.getCp());
        assertEquals(202, createdAquali.getHp());
        assertEquals(5000, createdAquali.getDust());
        assertEquals(4, createdAquali.getCandy());
        assertEquals(186, createdAquali.getAttack());
        assertEquals(168, createdAquali.getDefense());
        assertEquals(260, createdAquali.getStamina());
        assertEquals(100, createdAquali.getIv(), 0.1);
    }
}
