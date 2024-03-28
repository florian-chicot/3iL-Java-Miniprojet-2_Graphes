package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.*;

/**
 * La classe AlgorithmeDijkstra<E> implémente l'interface AlgorithmeChemin<E>.
 * Elle fournit une implémentation de l'algorithme de Dijkstra pour trouver le chemin le plus court entre deux noeuds
 * dans un graphe pondéré.
 *
 * @param <E> Le type générique des noeuds dans le graphe.
 */
public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

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
        Map<Noeud<E>, Noeud<E>> noeudsPrecedents = new HashMap<>();
        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(couts::get));

        for (Noeud<E> noeud : graphe.getNoeuds()) {
            couts.put(noeud, Double.POSITIVE_INFINITY);
            noeudsPrecedents.put(noeud, null);
        }
        couts.put(depart, 0.0);
        filePriorite.add(depart);
        while (!filePriorite.isEmpty()) {
            Noeud<E> noeud = filePriorite.poll();
            if (noeud.equals(arrivee)) {
                break;
            }
            for (Noeud<E> voisin : graphe.getVoisins(noeud)) {
                double cout = couts.get(noeud) + graphe.getCoutArete(noeud, voisin);

                if (cout < couts.get(voisin)) {
                    couts.put(voisin, cout);
                    noeudsPrecedents.put(voisin, noeud);
                    filePriorite.add(voisin);
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
