package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreateTrainer() {

        String trainerName = "Sacha";
        IPokedex pokedex = mock(IPokedex.class);

        PokemonTrainer trainer = new PokemonTrainer(trainerName, Team.MYSTIC, pokedex);

        when(trainerFactory.createTrainer(trainerName, Team.MYSTIC,pokedexFactory)).thenReturn(trainer);

        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, Team.MYSTIC, pokedexFactory);

        assertNotNull(createdTrainer);
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(pokedex, createdTrainer.getPokedex());

        verify(trainerFactory, times(1)).createTrainer(trainerName,Team.MYSTIC, pokedexFactory);
    }
}
