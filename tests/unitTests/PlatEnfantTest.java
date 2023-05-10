package tests.unitTests;

import menufact.plats.PlatEnfant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatEnfantTest {

    @Test
    void getProportion()
    {
        PlatEnfant platEnfant = new PlatEnfant(1, "PlatEnfant", 12,  1/2);

        assertEquals(1/2,platEnfant.getProportion());
    }
}