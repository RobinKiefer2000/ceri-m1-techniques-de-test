package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {

        metadataProvider = mock(IPokemonMetadataProvider.class);

    }

    @Test
    public void testGetPokemonMetadata() throws Exception {

        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadata Bulbizarre = metadataProvider.getPokemonMetadata(0);
        assertEquals(0, Bulbizarre.getIndex());
        assertEquals("Bulbizarre", Bulbizarre.getName());
        assertEquals(126, Bulbizarre.getAttack());
        assertEquals(126, Bulbizarre.getDefense());
        assertEquals(90, Bulbizarre.getStamina());


        when(metadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));

        PokemonMetadata Aquali = metadataProvider.getPokemonMetadata(133);
        assertEquals(133, Aquali.getIndex());
        assertEquals("Aquali", Aquali.getName());
        assertEquals(186, Aquali.getAttack());
        assertEquals(168, Aquali.getDefense());
        assertEquals(260, Aquali.getStamina());
    }
}
