package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.List;

/**
 * L'interface AlgorithmeChemin<E> définit un contrat pour les classes qui implémentent des algorithmes de recherche de
 * chemin dans un graphe.
 *
 * @param <E> Le type générique des noeuds dans le graphe.
 */
public interface AlgorithmeChemin<E> {

    /**
     * Recherche un chemin entre un noeud de départ et un noeud d'arrivée dans un graphe donné.
     *
     * @param graphe  Le graphe dans lequel la recherche doit être effectuée.
     * @param depart  Le noeud de départ.
     * @param arrivee Le noeud d'arrivée.
     * @return Une liste de noeuds représentant le chemin trouvé entre le noeud de départ et le noeud d'arrivée dans le
     * graphe.
     */
    List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);
}
