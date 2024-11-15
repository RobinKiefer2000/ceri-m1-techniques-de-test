package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Comparator;

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

    @Test
    public void testGetPokemonsSorted() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals("Bulbizarre", sortedPokemons.get(0).getName());
        assertEquals("Aquali", sortedPokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonMetadataFromPokedex() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testCreatePokemonFromPokedex() {
        Pokemon createdPokemon = pokedex.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(133, createdPokemon.getIndex());
        assertEquals(2729, createdPokemon.getCp());
        assertEquals(202, createdPokemon.getHp());
        assertEquals(5000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
    }
}
