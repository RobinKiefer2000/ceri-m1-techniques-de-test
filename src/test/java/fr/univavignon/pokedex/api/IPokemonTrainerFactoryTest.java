package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }
}
