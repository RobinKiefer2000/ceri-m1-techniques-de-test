package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testAddPokemon() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        int index = pokedex.addPokemon(bulbizarre);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        pokedex.addPokemon(bulbizarre);
        Pokemon retrieved = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", retrieved.getName());
    }

    @Test
    public void testGetPokemons() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }
}
