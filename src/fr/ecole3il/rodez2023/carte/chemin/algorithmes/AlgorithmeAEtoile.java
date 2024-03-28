package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Case;

import java.util.*;

/**
 * La classe AlgorithmeAEtoile<E> implémente l'interface AlgorithmeChemin<E>.
 * Elle utilise l'algorithme A* pour trouver un chemin entre un noeud de départ et un noeud d'arrivée dans un graphe
 * donné.
 *
 * @param <E> Le type générique des noeuds dans le graphe.
 */
public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {

    /**
     * Recherche un chemin entre un noeud de départ et un noeud d'arrivée dans un graphe donné.
     *
     * @param graphe  Le graphe dans lequel la recherche doit être effectuée.
     * @param depart  Le noeud de départ.
     * @param arrivee Le noeud d'arrivée.
     * @return Une liste de noeuds représentant le chemin trouvé entre le noeud de départ et le noeud d'arrivée dans le
     * graphe.
     */
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        Map<Noeud<E>, Double> couts = new HashMap<>();
        Map<Noeud<E>, Double> coutsEstime = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> noeudsPrecedents = new HashMap<>();
        PriorityQueue<Noeud<E>> filePriotite = new PriorityQueue<>(Comparator.comparingDouble(couts::get));

        for (Noeud<E> noeud : graphe.getNoeuds()) {
            couts.put(noeud, Double.POSITIVE_INFINITY);
            coutsEstime.put(noeud, Double.POSITIVE_INFINITY);
            noeudsPrecedents.put(noeud, null);
        }
        couts.put(depart, 0.0);
        coutsEstime.put(depart, 0.0);
        filePriotite.add(depart);
        while (!filePriotite.isEmpty()) {
            Noeud<E> noeud = filePriotite.poll();
            if (noeud.equals(arrivee)) break;
            for (Noeud<E> voisin : graphe.getVoisins(noeud)) {
                double cout = couts.get(noeud) + graphe.getCoutArete(noeud, voisin);
                if (cout < couts.get(voisin)) {
                    noeudsPrecedents.put(voisin, noeud);
                    couts.put(voisin, cout);
                    coutsEstime.put(voisin, cout);
                    filePriotite.add(voisin);
                }
            }
        }
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeud = arrivee;
        while (noeud != null) {
            chemin.add(noeud);
            noeud = noeudsPrecedents.get(noeud);
        }
        Collections.reverse(chemin);
        return chemin;
    }
}