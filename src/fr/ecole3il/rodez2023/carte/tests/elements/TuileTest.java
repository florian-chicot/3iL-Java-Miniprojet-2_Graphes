package fr.ecole3il.rodez2023.carte.tests.elements;

import fr.ecole3il.rodez2023.carte.elements.Tuile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuileTest {

    @Test
    void getPenalite() {
        assertEquals(1, Tuile.DESERT.getPenalite());
        assertEquals(3, Tuile.MONTAGNES.getPenalite());
        assertEquals(2, Tuile.PLAINE.getPenalite());
        assertEquals(4, Tuile.FORET.getPenalite());
    }
}