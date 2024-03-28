package fr.ecole3il.rodez2023.carte;


import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe AdaptateurAlgorithme
 */
public class AdaptateurAlgorithme {

    /**
     * Trouve le chemin le plus court entre deux cases sur la carte en utilisant l'algorithme spécifié.
     *
     * @param algorithme l'algorithme de recherche de chemin
     * @param carte      la carte sur laquelle le chemin est recherché
     * @param xDepart    la coordonnée x de la case de départ
     * @param yDepart    la coordonnée y de la case de départ
     * @param xArrivee   la coordonnée x de la case d'arrivée
     * @param yArrivee   la coordonnée y de la case d'arrivée
     * @return le chemin trouvé entre les cases de départ et d'arrivée
     */
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
        Graphe<Case> graphe = creerGraphe(carte);
        Noeud<Case> depart = getNoeud(graphe, xDepart, yDepart);
        Noeud<Case> arrivee = getNoeud(graphe, xArrivee, yArrivee);
        List<Noeud<Case>> cheminNoeuds = algorithme.trouverChemin(graphe, depart, arrivee);
        List<Case> cheminCases = new ArrayList<>();
        for (Noeud<Case> noeud : cheminNoeuds) {
            cheminCases.add(noeud.getValeur());
        }
        return new Chemin(cheminCases);
    }

    /**
     * Retourne le noeud au coordonnées (x, y) dans le graphe donné.
     *
     * @param graphe le graphe contenant les noeuds
     * @param x      la coordonnée x du noeud recherché
     * @param y      la coordonnée y du noeud recherché
     * @return le noeud correspondant aux coordonnées spécifiées
     */
    private static Noeud<Case> getNoeud(Graphe graphe,int x, int y) {
        for (Object noeud : graphe.getNoeuds()) {
            Case caseActuelle = (Case) ((Noeud)noeud).getValeur();
            if (caseActuelle.getX() == x && caseActuelle.getY() == y) {
                return (Noeud)noeud;
            }
        }
        return null;
    }

    /**
     * Crée un graphe représentant la carte.
     *
     * @param carte la carte à partir de laquelle créer le graphe
     * @return le graphe représentant la carte
     */
    static Graphe<Case> creerGraphe(Carte carte){
        Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Case caseActuelle = new Case(carte.getTuile(x, y), x, y);
                graphe.ajouterNoeud(new Noeud<>(caseActuelle));
            }
        }
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Case caseActuelle = new Case(carte.getTuile(x, y), x, y);
                ajouterAretesVoisines(graphe, caseActuelle, x, y, largeur, hauteur);
            }
        }
        return graphe;
    }

    /**
     * Ajoute des arêtes entre une case donnée et ses cases voisines dans le graphe.
     *
     * @param graphe      le graphe auquel ajouter les arêtes
     * @param currentCase la case pour laquelle ajouter les arêtes
     * @param x           la coordonnée x de la case actuelle
     * @param y           la coordonnée y de la case actuelle
     * @param largeur     la largeur de la carte
     * @param hauteur     la hauteur de la carte
     */
    private static void ajouterAretesVoisines(Graphe<Case> graphe, Case currentCase, int x, int y, int largeur, int hauteur) {
        Noeud<Case> currentNoeud = new Noeud<Case>(currentCase);
        if (x > 0) {
            Noeud<Case> leftNeighbor = getNoeud(graphe, x - 1, y);
            graphe.ajouterArete(currentNoeud, leftNeighbor, calculerCout(currentCase, leftNeighbor.getValeur()));
        }
        if (x < largeur - 1) {
            Noeud<Case> rightNeighbor = getNoeud(graphe,x + 1, y);
            graphe.ajouterArete(currentNoeud, rightNeighbor, calculerCout(currentCase, rightNeighbor.getValeur()));
        }
        if (y > 0) {
            Noeud<Case> topNeighbor = getNoeud(graphe,x, y - 1);
            graphe.ajouterArete(currentNoeud, topNeighbor, calculerCout(currentCase, topNeighbor.getValeur()));
        }
        if (y < hauteur - 1) {
            Noeud<Case> bottomNeighbor = getNoeud(graphe,x, y + 1);
            graphe.ajouterArete(currentNoeud, bottomNeighbor, calculerCout(currentCase, bottomNeighbor.getValeur()));
        }
    }

    /**
     * Calcule le coût pour se déplacer d'une case à une autre.
     *
     * @param depart  la case de départ
     * @param arrivee la case d'arrivée
     * @return le coût pour se déplacer de la case de départ à la case d'arrivée
     */
    private static double calculerCout(Case depart, Case arrivee) {
        return Math.abs(depart.getX() - arrivee.getX()) + Math.abs(depart.getY() - arrivee.getY());
    }

    /**
     * Affiche le chemin dans la console.
     *
     * @param chemin le chemin à afficher
     */
    private static void afficherChemin(List<Noeud<Case>> chemin) {
        for (Noeud<Case> noeud : chemin) {
            System.out.println(noeud.getValeur());
        }
    }
}