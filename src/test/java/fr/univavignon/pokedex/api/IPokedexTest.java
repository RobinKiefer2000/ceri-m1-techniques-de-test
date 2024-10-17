package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {

        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testAddPokemon() {

        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        when(pokedex.addPokemon(bulbizarre)).thenReturn(1);

        Integer result = pokedex.addPokemon(bulbizarre);

        assertEquals(Integer.valueOf(1), result);

        verify(pokedex, times(1)).addPokemon(bulbizarre);
    }

    @Test
    public void testGetPokemons() {


        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        Pokemon aquali = new Pokemon(0, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbizarre, aquali));

        List<Pokemon> pokemons = pokedex.getPokemons();

        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());

        verify(pokedex, times(1)).getPokemons();
    }

    @Test
    public void testGetPokemon() throws PokedexException {

        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(bulbizarre);

        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);

        Pokemon retrievedPokemon = pokedex.getPokemon(0);

        assertNotNull(retrievedPokemon);
        assertEquals(0, retrievedPokemon.getIndex());
        assertEquals("Bulbizarre", retrievedPokemon.getName());

        verify(pokedex, times(1)).getPokemon(0);
    }

}
