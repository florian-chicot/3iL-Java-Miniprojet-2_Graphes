package fr.ecole3il.rodez2023.carte.tests.elements;

import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Tuile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheminTest {

    @Test
    void getCases() {
        Case case1 = new Case(Tuile.DESERT, 0, 0);
        Case case2 = new Case(Tuile.PLAINE, 1, 1);
        Case case3 = new Case(Tuile.FORET, 2, 2);
        List<Case> casesList = new ArrayList<>();
        casesList.add(case1);
        casesList.add(case2);
        casesList.add(case3);
        Chemin chemin = new Chemin(casesList);
        assertEquals(casesList, chemin.getCases());
    }
}