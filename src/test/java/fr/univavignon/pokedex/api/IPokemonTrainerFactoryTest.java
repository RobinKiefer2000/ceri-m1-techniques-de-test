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
        Team team = Team.MYSTIC;
        IPokedex pokedex = mock(IPokedex.class);

        PokemonTrainer trainer = new PokemonTrainer(trainerName, team, pokedex);

        when(trainerFactory.createTrainer(trainerName, team,pokedexFactory)).thenReturn(trainer);

        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertNotNull(createdTrainer);
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(team, createdTrainer.getTeam());
        assertEquals(pokedex, createdTrainer.getPokedex());

        verify(trainerFactory, times(1)).createTrainer(trainerName,team, pokedexFactory);
    }
}
