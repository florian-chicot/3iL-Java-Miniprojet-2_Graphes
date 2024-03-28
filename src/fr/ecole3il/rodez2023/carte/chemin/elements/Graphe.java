package fr.ecole3il.rodez2023.carte.chemin.elements;

import fr.ecole3il.rodez2023.carte.elements.Case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La classe Graphe<E> représente un graphe utilisant une structure de données basée sur une Map
 * pour stocker les informations sur les arêtes. Elle offre des méthodes pour ajouter des noeuds
 * au graphe, ajouter des arêtes entre les noeuds avec des coûts associés, obtenir le coût d'une
 * arête entre deux noeuds spécifiques, ainsi que pour obtenir des informations sur les noeeeeeuds et
 * leurs voisins.
 *
 * @param <E> Le type générique des noeuds dans le graphe.
 */
public class Graphe<E> {
    /**
     * La Map arete associe chaque noeud à une autre Map.
     * La clé est un noeud voisin et la valeur est le coût de l'arête.
     */
    private Map<Noeud<E>, Map<Noeud<E>, Double>> arete;

    /**
     * Constructeur par défaut qui initialise la Map des arêtes.
     */
    public Graphe() {
        this.arete = new HashMap<>();
    }

    /**
     * Ajoute un noeeud au graphe si le noeud n'existe pas déjà.
     *
     * @param noeud Le noeud à ajouter au graphe.
     */
    public void ajouterNoeud(Noeud<E> noeud) {
        if(!this.arete.containsKey(noeud)) {
            this.arete.put(noeud, new HashMap<>());
        }
    }

    /**
     * Ajoute une arête pondérée entre deux noeuds du graphe.
     *
     * @param depart  Le noeud de départ.
     * @param arrivee Le noeud d'arrivée.
     * @param cout    Le coût de l'arête.
     */
    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        ajouterNoeud(depart);
        ajouterNoeud(arrivee);
        this.arete.get(depart).put(arrivee, cout);
    }

    /**
     * Renvoie le coût de l'arête entre deux noeuds spécifiés.
     *
     * @param depart  Le noeud de départ.
     * @param arrivee Le noeud d'arrivée.
     * @return Le coût de l'arête entre les deux noeuds spécifiés, ou Double.POSITIVE_INFINITY si l'arête n'existe pas.
     */
    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
        if(this.arete.containsKey(depart) && this.arete.containsKey(arrivee)) {
            return arete.get(depart).get(arrivee);
        }
        return Double.POSITIVE_INFINITY;
    }

    /**
     * Renvoie une liste contenant tous les noeuds du graphe.
     *
     * @return Une liste contenant tous les noeuds du graphe.
     */
    public List<Noeud<E>> getNoeuds() {
        return new ArrayList<>(arete.keySet());
    }

    /**
     * Renvoie une liste contenant tous les voisins d'un noeud spécifié.
     * Si le noeud n'existe pas dans le graphe, elle renvoie une liste vide.
     *
     * @param noeud Le noeud spécifié.
     * @return Une liste contenant tous les voisins du noeud spécifié.
     */
    public List<Noeud<E>> getVoisins(Noeud<E> noeud) {
        if(this.arete.containsKey(noeud)) {
            return new ArrayList<>(this.arete.get(noeud).keySet());
        }
        return new ArrayList<>();
    }
}
