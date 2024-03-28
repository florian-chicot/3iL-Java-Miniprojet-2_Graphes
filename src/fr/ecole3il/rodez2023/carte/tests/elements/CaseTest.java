package fr.ecole3il.rodez2023.carte.tests.elements;

import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Tuile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseTest {

    @Test
    void getTuile() {
        Tuile tuile = Tuile.FORET;
        Case testCase = new Case(tuile, 2, 3);
        assertEquals(tuile, testCase.getTuile());
    }

    @Test
    void getX() {
        Tuile tuile = Tuile.FORET;
        Case testCase = new Case(tuile, 2, 3);
        assertEquals(2, testCase.getX());
    }

    @Test
    void getY() {
        Tuile tuile = Tuile.FORET;
        Case testCase = new Case(tuile, 2, 3);
        assertEquals(3, testCase.getY());
    }
}