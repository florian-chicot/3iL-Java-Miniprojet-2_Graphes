# Réponses aux questions

**Question :** Quelle structure de données pourrait être utilisée pour stocker les relations entre les noeuds du graphe et les informations associées à ces relations, comme les coûts des arêtes ?

Une Map où les clefs représentent les noeuds et les valeurs représentent les informations sur les arêtes.

**Question :** Pourquoi pensez-vous que les classes `Noeud` et `Graphe` ont été définies avec des paramètres génériques ?

L'intérêt d'utiliser des paramètres génériques permet d'utiliser les classes avce différents types de données sans avoir besoin de modifier les classes.

**Question :** Pourquoi pensez-vous que la création d'une interface est une bonne pratique dans ce contexte ?

C'est une bonne praitque car elle définit pour les classes qui implémentent les algorithmes de recherche de chemin entre
des noeuds.
