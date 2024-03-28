package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Noeud représente un noeud générique dans une structure de graphe.
 * Un noeud possède une valeur de type générique E et une liste de noeuds voisins, également de type E.
 *
 * @author florian-chicot
 */
public class Noeud<E> {

    private E valeur;
    private List<Noeud<E>> voisins;

    /**
     * Construit un nouveau noeud avec la valeur spécifiée et initialise la liste des noeuds voisins.
     *
     * @param valeur La valeur du noeud.
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<Noeud<E>>();
    }

    /**
     * Renvoie la valeur du noeud.
     *
     * @return La valeur du noeud.
     */
    public E getValeur() {
        return valeur;
    }

    /**
     * Renvoie la liste des noeuds voisins.
     *
     * @return La liste des noeuds voisins.
     */
    public List<Noeud<E>> getVoisins() {
        return this.voisins;
    }

    /**
     * Ajoute un noeud voisin à la liste des voisins d'un noeud spécifié.
     *
     * @param voisin Le noeud voisin à ajouter.
     */
    public void ajouterVoisin(Noeud<E> voisin) {
        this.voisins.add(voisin);
    }
}
