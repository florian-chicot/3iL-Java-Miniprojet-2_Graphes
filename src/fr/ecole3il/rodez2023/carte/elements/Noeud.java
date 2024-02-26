package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Noeud représente un nœud générique dans une structure de graphe.
 * Un nœud possède une valeur de type générique E et une liste de nœuds voisins, également de type E.
 *
 * @author florian-chicot
 */
public class Noeud<E> {

    private E valeur;
    private List<Noeud<E>> voisins;

    /**
     * Construit un nouveau nœud avec la valeur spécifiée et initialise la liste des nœuds voisins.
     *
     * @param valeur La valeur du nœud.
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<Noeud<E>>();
    }

    /**
     * Renvoie la valeur du nœud.
     *
     * @return La valeur du nœud.
     */
    public E getValeur() {
        return valeur;
    }

    /**
     * Renvoie la liste des nœuds voisins.
     *
     * @return La liste des nœuds voisins.
     */
    public List<Noeud<E>> getVoisins() {
        return this.voisins;
    }

    /**
     * Ajoute un nœud voisin à la liste des voisins d'un nœud spécifié.
     *
     * @param voisin Le nœud voisin à ajouter.
     */
    public void ajouterVoisin(Noeud<E> voisin) {
        this.voisins.add(voisin);
    }
}
