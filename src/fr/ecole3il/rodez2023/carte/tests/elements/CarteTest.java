package fr.ecole3il.rodez2023.carte.tests.elements;

import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @org.junit.jupiter.api.Test
    void getTuile() {
        Tuile[][] tuiles = {
                {Tuile.DESERT, Tuile.PLAINE},
                {Tuile.FORET, Tuile.MONTAGNES}
        };
        Carte carte = new Carte(tuiles);
        assertEquals(Tuile.DESERT, carte.getTuile(0, 0));
        assertEquals(Tuile.PLAINE, carte.getTuile(0, 1));
        assertEquals(Tuile.FORET, carte.getTuile(1, 0));
        assertEquals(Tuile.MONTAGNES, carte.getTuile(1, 1));
    }

    @org.junit.jupiter.api.Test
    void getLargeur() {
        Tuile[][] tuiles = {
                {Tuile.DESERT, Tuile.PLAINE},
                {Tuile.FORET, Tuile.MONTAGNES}
        };
        Carte carte = new Carte(tuiles);
        assertEquals(2, carte.getLargeur());
    }

    @org.junit.jupiter.api.Test
    void getHauteur() {
        Tuile[][] tuiles = {
                {Tuile.DESERT, Tuile.PLAINE},
                {Tuile.FORET, Tuile.MONTAGNES}
        };
        Carte carte = new Carte(tuiles);
        assertEquals(2, carte.getHauteur());
    }
}