package tests.unitTests;

import menufact.plats.PlatSante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatSanteTest {
    PlatSante platSante;
    @BeforeEach
    void setUp()
    {
        platSante = new PlatSante(1, "PlatEnfant", 12,100,200,300);


    }

    @Test
    void testToString() {
    }

    @Test
    void getKcal()
    {
        assertEquals(100,platSante.getKcal());
    }

    @Test
    void getChol()
    {
        assertEquals(200,platSante.getChol());
    }

    @Test
    void getGras() {
        assertEquals(300,platSante.getGras());
    }
}